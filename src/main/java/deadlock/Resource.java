package deadlock;

/**
 * Created by yan on 2016/1/30.
 */

/**
 * 该类存放两个资源等待被使用 死锁代码
 * @author lu
 *
 */
public class Resource {

    public static Object o1 = new Object();
    public static Object o2 = new Object();



    public static void main(String[] args) {
        DeadThread1 dt1 = new DeadThread1();
        DeadThread2 dt2 = new DeadThread2();

        Thread t1 = new Thread(dt1);
        Thread t2 = new Thread(dt2);

        //启动两个线程
        t1.start();
        t2.start();
    }
}
