简单说**epoll和select/poll最大区别**是
1.epoll内部使用了mmap共享了用户和内核的部分空间，避免了数据的来回拷贝
2.epoll基于事件驱动，epoll_ctl注册事件并注册callback回调函数，epoll_wait只返回发生的事件避免了像select和poll对事件的整个轮寻操作。

**IO处理**：
1. 方法就是最传统的多进程并发模型 (每进来一个新的I/O流会分配一个新的进程管理。)
2. I/O多路复用 (单个线程，通过记录跟踪每个I/O流(sock)的状态，来同时管理多个I/O流 。)

**I/O多路复用** 英文I/O multiplexing
就是多个Sock复用一根网线这个功能是在内核＋驱动层实现的。
详细一点就是： I/O multiplexing 这里面的 multiplexing 指的其实是在单个线程通过记录跟踪每一个Sock(I/O流)的状态(对应空管塔里面的Fight progress strip槽)来同时管理多个I/O流.

![](https://pic2.zhimg.com/18d8525aceddb840ea4c131002716221_b.jpg)
在同一个线程里面， 通过拨开关的方式，来同时传输多个I/O流

nginx中使用了epoll，是基于事件驱动模型的，由一个或多个事件收集器来收集或者分发事件，epoll就属于事件驱动模型的事件收集器，将注册过的事件中发生的事件收集起来，master进程负责管理worker进程.


**epoll分为两种工作方式LT和ET**:

- LT(level triggered) **电平触发**,是默认/缺省的工作方式，同时支持 block和no_block socket。这种工作方式下，内核会通知你一个fd是否就绪，然后才可以对这个就绪的fd进行I/O操作。就算你没有任何操作，系统还是会继续提示fd已经就绪，不过这种工作方式出错会比较小，传统的select/poll就是这种工作方式的代表。
- ET(edge-triggered) **边沿触发** 是高速工作方式，仅支持no_block socket，这种工作方式下，当fd从未就绪变为就绪时，内核会通知fd已经就绪，并且内核认为你知道该fd已经就绪，不会再次通知了，除非因为某些操作导致fd就绪状态发生变化。如果一直不对这个fd进行I/O操作，导致fd变为未就绪时，内核同样不会发送更多的通知，因为only once。所以这种方式下，出错率比较高，需要增加一些检测程序。

LT可以理解为水平触发，只要有数据可以读，不管怎样都会通知。而ET为边缘触发，只有状态发生变化时才会通知，可以理解为电平变化。

**IO多路复用技术**：通过该技术，系统内核缓冲I/O数据，当某个I/O准备好后，系统通知应用程序该I/O可读或可写，这样应用程序可以马上完成相应的I/O操作，而不需要等待系统完成相应I/O操作，从而应用程序不必因等待I/O操作而阻塞。