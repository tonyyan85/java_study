package off.subjecg46;

/**
 *
 * Created by yan on 2016/4/21.
 */
public class SumInt {

    public static int sum1(int n)
    {
        int sum = 0;
        for(int i = 1;i <= n;++i)
            sum += i;
        return sum;
    }

    public static int sum2(int n)
    {
        if(n < 1)
            return 0;
        return n + sum2(n - 1);
    }

    public static void main(String args[]){
        System.out.println(sum2(3));
    }
}
