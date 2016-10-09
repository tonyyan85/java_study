package test;

/**
 * Created by czadmin on 2016/6/23.
 */
public class WhileTest {
    public static void main(String args[]) throws InterruptedException {
        while (true)
        {
            if(false)
            {
                Thread.sleep(5);
                continue;
            }
            System.out.println("-------15");
            break;
        }
        System.out.println("-------18");
    }
}
