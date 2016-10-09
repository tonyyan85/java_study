package test;

/**
 * Created by czadmin on 2016/10/9.
 */
public class TryTest {
    public static void main(String args[]){
        System.out.println(new TryTest().boolTest());
    }

    public boolean boolTest(){
        try {

            return true;
        }catch (Exception e){

        }finally {
            System.out.println("fffffff");
        }
        return false;
    }

}
