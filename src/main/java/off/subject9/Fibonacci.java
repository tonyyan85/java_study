package off.subject9;

/**
 * Created by yan on 2016/4/1.
 */
public class Fibonacci {

    public int getFibonacciInfo(int i){
        if(i <=0){
            return 0;
        }
        if(i == 1){
            return 1;
        }

        return getFibonacciInfo(i-1) + getFibonacciInfo(i-2);
    }

    public static void main(String args[]){
        System.out.println(new Fibonacci().getFibonacciInfo(2));
    }

}
