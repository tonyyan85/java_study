package instanceofTest;

/**
 * Created by yan on 2016/3/13.
 */
public class Test {
    public static void main(String args[]){
        Atest b = new BtestExtenseA();
        Atest c = new CtestExtenseA();

        if(c instanceof BtestExtenseA);
        System.out.println(true);

        System.out.println(c.getClass()==BtestExtenseA.class);
        System.out.println(c.getClass()==CtestExtenseA.class);
    }
}
