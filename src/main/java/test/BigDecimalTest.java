package test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by czadmin on 2016/7/5.
 */
public class BigDecimalTest {

    public static void main(String args[]){
        BigDecimal big = new BigDecimal("-1");
        System.out.println(new BigDecimal("2").add(big));

        for(int i=10;i>0;i--){
            break;
        }
        System.out.println("ffff");


        DecimalFormat mformat = new DecimalFormat("#.##");
        System.out.println(mformat.format(new BigDecimal("0.44")));

        System.out.println((new BigDecimal("0.44").toString()));


    }
}
