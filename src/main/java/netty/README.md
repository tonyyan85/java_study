##Netty

- [Netty系列之Netty高性能](http://www.infoq.com/cn/articles/netty-high-performance/),全局介绍netty的高性能特点：
    - **使用NIO的异步非阻塞通信**，并使用了JDK1.5_update10版本的epoll替代了传统的select/poll，极大的提升了NIO通信的性能。
    - **零拷贝**，
        1. Netty的接收和发送ByteBuffer采用DIRECT BUFFERS，使用堆外直接内存进行Socket读写，不需要进行字节缓冲区的二次拷贝。如果使用传统的堆内存（HEAP BUFFERS）进行Socket读写，JVM会将堆内存Buffer拷贝一份到直接内存中，然后才写入Socket中。相比于堆外直接内存，消息在发送过程中多了一次缓冲区的内存拷贝。
        2. Netty提供了组合Buffer对象，可以聚合多个ByteBuffer对象，用户可以像操作一个Buffer那样方便的对组合Buffer进行操作，避免了传统通过内存拷贝的方式将几个小Buffer合并成一个大的Buffer。
        3. Netty的文件传输采用了transferTo方法，它可以直接将文件缓冲区的数据发送到目标Channel，避免了传统通过循环write方式导致的内存拷贝问题。
    - **内存池** Netty提供了基于内存池的缓冲区重用机制
    - **高效的Reactor线程模型**
        1) **Reactor单线程模型**；
            - 一个NIO线程确实可以完成其承担的职责。例如，通过Acceptor接收客户端的TCP连接请求消息，链路建立成功之后，通过Dispatch将对应的ByteBuffer派发到指定的Handler上进行消息解码。用户Handler可以通过NIO线程将消息发送给客户端。
        2) **Reactor多线程模型**；
            - 有专门一个NIO线程-Acceptor线程用于监听服务端，接收客户端的TCP连接请求；
            - 网络IO操作-读、写等由一个NIO线程池负责，线程池可以采用标准的JDK线程池实现，它包含一个任务队列和N个可用的线程，由这些NIO线程负责消息的读取、解码、编码和发送；
            - 1个NIO线程可以同时处理N条链路，但是1个链路只对应1个NIO线程，防止发生并发操作问题。
        3) **主从Reactor多线程模型**
            服务端用于接收客户端连接的不再是个1个单独的NIO线程，而是一个独立的NIO线程池。Acceptor接收到客户端TCP连接请求处理完成后（可能包含接入认证等），将新创建的SocketChannel注册到IO线程池（sub reactor线程池）的某个IO线程上，由它负责SocketChannel的读写和编解码工作。Acceptor线程池仅仅只用于客户端的登陆、握手和安全认证，一旦链路建立成功，就将链路注册到后端subReactor线程池的IO线程上，由IO线程负责后续的IO操作。
    - **无锁化的串行设计理念**,Netty的NioEventLoop读取到消息之后，直接调用ChannelPipeline的

![](http://cdn2.infoqstatic.com/statics_s2_20161122-0331/resource/articles/netty-high-performance/zh/resources/0529012.png)
NIO的多路复用模型图

![](http://cdn2.infoqstatic.com/statics_s2_20161122-0331/resource/articles/netty-high-performance/zh/resources/0529013.png)
Reactor模式设计和实现