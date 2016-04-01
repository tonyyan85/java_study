package off.subject9;

/**
 * Created by yan on 2016/4/1.
 */
public class GoodFibonacci {
    public int getFibonacciInfo(int n){
        int result[] = {0,1};
        if(n < 2){
            return result[n];
        }

        int fibNMinusOne = 1;
        int fibNMinusTwo = 0;
        int fibN = 0;

        for(int i = 2; i <= n;i++){
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusOne = fibN;
            fibNMinusTwo = fibNMinusOne;
        }

        return fibN;
    }

    public static void main(String args[]){
        System.out.println(new GoodFibonacci().getFibonacciInfo(2));
    }
}
