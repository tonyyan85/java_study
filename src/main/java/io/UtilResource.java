package io;

/**
 * Created by Administrator on 2016/5/11.
 */
import java.io.*;
public class UtilResource {
    private void initializeResource() {
        try {

            //读取文件，并且以utf-8的形式写出去
            BufferedReader bufread;
            String read;
//            bufread = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream("C:\\script.txt"))));

            bufread = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\script.txt")));
            while ((read = bufread.readLine()) != null) {
                System.out.println(read);
            }

            System.out.println("-----另一种方法------");

            BufferedReader bufread1 = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\script.txt")));
            char[] buf = new char[1024];
            int temp = 0;
            // 将字符读入数组。返回：读取的字符数，如果已到达流的末尾，则返回 -1
            while ((temp = bufread1.read(buf)) != -1) {
                /**
                 * 通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String。新 String 的长度是字符集的函数，因此可能不等于该子数组的长度。
                 * bytes - 要解码为字符的 byte
                 * offset - 要解码的第一个 byte 的索引
                 * length - 要解码的 byte 数
                 */
                System.out.println(new String(buf,0,temp));
            }

            bufread.close();
            bufread1.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]){
        UtilResource ur = new UtilResource();
        ur.initializeResource();
    }

}