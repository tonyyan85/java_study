package string;

/**
 * Created by czadmin on 2016/9/8.
 */
public class SplitTest {
    public static void main(String[] args){
        String str = "33*&&*大盘未来走势3000.00明天涨10%";
        String[] strs = str.split("\\*&&\\*");
        for(String ss : strs){
            System.out.println(ss);
        }
    }
}
