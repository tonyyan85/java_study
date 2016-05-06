package lock;

/**
 * Created by yan on 2016/1/30.
 */
/**
 * 线程启动调用run(),run()调用fun()方法
 * @author lu
 *
 */
public class DeadThread1 implements Runnable {

    @Override
    public void run() {
        fun();
    }

    //fun()方法首先占用o1资源,然后休眠1秒,让给其他线程执行。
    //然后请求o2资源
    public void fun() {
        synchronized (Resource.o1) {
            try {
                Thread.sleep(100);
                System.out.println("-----DeadThread1.fun-----");
            } catch (InterruptedException e) {
            }
            synchronized (Resource.o2) {
                System.out.println("DeadThread1里的fun()被执行");
            }
        }
    }

}