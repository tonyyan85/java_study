package string;

import java.util.Scanner;

/**
 * 回文小程序
 *
 * Created by yan on 2016/1/30.
 */
public class HiJava {


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int i = word.length();
        int j = 0;
        while (j <= (i / 2) - 1 && word.charAt(j) == word.charAt(i - j - 1)) {
            j++;
        }
        if (j == i / 2) System.out.println("Yes it is HuiWen.");
        else System.out.println("No it is not HuiWen.");
        sc.close();

    }

}
