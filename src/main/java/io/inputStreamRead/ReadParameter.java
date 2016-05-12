package io.inputStreamRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/5/12.
 */
public class ReadParameter {
    public static void main(String args[]){
        try {
            InputStream inputStream = new FileInputStream("C:\\script.txt");
            byte[] b = new byte[16];
            int i = 0;
            try {
                // read无参方法的使用
                while((i=inputStream.read(b))!=-1){
                    String str = new String(b);
                    System.out.print(str);
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
