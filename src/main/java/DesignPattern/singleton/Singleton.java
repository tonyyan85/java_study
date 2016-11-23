package DesignPattern.singleton;

/**
 * 用途：
 * 对于缓存，数据库连接，网络请求队列等，资源消耗比较大的，通常我们只是需要一个实例，来减少资源的消耗
 *
 * 双重检查加锁
 * Created by czadmin on 2016/11/23.
 */
public class Singleton {
    private volatile static Singleton mSingleton = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (mSingleton == null) {
            synchronized (Singleton.class) {
                if (mSingleton == null) mSingleton = new Singleton();
            }
        }
        return mSingleton;
    }
}

/*
这就是所谓的双重检查机制。看似已经完美，实则不然。mSingleton = new Singleton();实际上分为三个过程：
    1 分配内存
    2 对Singleton的一些初始化工作包括构造函数的执行
    3 对instance变量赋值内存地址
    然而对于第2步和第3步，不同的编译器由于执行了优化导致他们的执行顺序并不一致，即发生了重排序，对于重排序参见这篇infoq上的文章http://www.infoq.com/cn/articles/java-memory-model-2
    也就是线程1当执行到第2步的时候，instance就已经有值了，此时线程2执行getInstance方法的最外层的if(instance==null)判断就会直接返回。然而该对象还没有真正的完成初始化，还不能正常使用。此时线程2如果去使用该对象，就会出问题了。
*/
