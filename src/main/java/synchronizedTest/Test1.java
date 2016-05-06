package synchronizedTest;

/**
 * Created by Administrator on 2016/5/6.
 */
public class Test1 {

    public static void main(String[] args)  {
        final InsertData1 insertData = new InsertData1();
        new Thread(){
            @Override
            public void run() {
                insertData.insert();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                insertData.insert1();
            }
        }.start();
    }
}

class InsertData1 {
    public void insert(){
        synchronized(this){
            System.out.println("执行insert");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行insert完毕");
        }
    }

    public void insert1() {
        synchronized(this){
            System.out.println("执行insert1");
            System.out.println("执行insert1完毕");
        }
    }
}
