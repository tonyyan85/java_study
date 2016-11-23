package produceandconsume;

/**
 * http://www.cnblogs.com/skywang12345/p/3480016.html
 * Created by czadmin on 2016/11/23.
 */
public class Demo1 {
    public static void main(String[] args) {
        Depot mDepot = new Depot(100);
        Producer mPro = new Producer(mDepot);
        Customer mCus = new Customer(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}
