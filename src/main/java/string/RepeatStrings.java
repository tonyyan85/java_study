package string;

/**
 * Created by yan on 2016/1/30.
 * 字符串中有多少个相同字符
 */
public class RepeatStrings {
    public static int countStr(String str1, String str2) {
        int counter=0;
        if (str1.indexOf(str2) == -1) {
            return 0;
        }
        while(str1.indexOf(str2)!=-1){
            counter++;
            str1=str1.substring(str1.indexOf(str2)+str2.length());
        }
        return counter;
    }

    public static void main(String args[]){
        System.out.println(countStr("fadfadsfasdfafdfdfderwewsdsdfd", "fd"));
    }
}
