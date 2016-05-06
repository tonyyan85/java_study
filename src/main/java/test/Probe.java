package test;

/**
 * Created by Administrator on 2016/5/5.
 */
public class Probe extends Thread {
    public Probe() {}
    public void run() {
        while(true) {
            Thread[] x = new Thread[2];
            Thread.enumerate(x);
            for(int i=0; i<2; i++) {
                Thread t = x[i];
                if(t == null)
                    break;
                else
                    System.out.println(t.getName() + "\t" + t.getPriority()
                            + "\t" + t.isAlive() + "\t" + t.isDaemon());
            }
        }
    }

    public static void main(String[] args) {
        Probe dt1 = new Probe();
        Thread t1 = new Thread(dt1);

        //启动两个线程
        t1.start();
    }
}
