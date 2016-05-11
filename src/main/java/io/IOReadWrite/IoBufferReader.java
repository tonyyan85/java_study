package io.IOReadWrite;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2016/5/11.
 */
public class IoBufferReader {
    public static void main(String[] args ) {
        String path = File.separator + "home" + File.separator + "siu" +
                File.separator + "work" + File.separator + "demo.txt";

        FileReader r = null;
        try {
            r = new FileReader(path);

            //方式一：读取单个字符的方式
            //每读取一次，向下移动一个字符单位
/*            int temp1 = r.read();
            System.out.println((char)temp1);
            int temp2 = r.read();
            System.out.println((char)temp2);*/

            //方式二：循环读取
            //read()方法读到文件末尾会返回-1
            /*
            while (true) {
                int temp = r.read();
                if (temp == -1) {
                    break;
                }
                System.out.print((char)temp);
            }
            */

            //方式三：循环读取的简化操作
            //单个字符读取，当temp不等于-1的时候打印字符
            /*int temp = 0;
            while ((temp = r.read()) != -1) {
                System.out.print((char)temp);
            }
            */

            //方式四：读入到字符数组
            /*
            char[] buf = new char[1024];
            int temp = r.read(buf);
            //将数组转化为字符串打印,后面参数的意思是
            //如果字符数组未满，转化成字符串打印后尾部也许会出现其他字符
            //因此，读取的字符有多少个，就转化多少为字符串
            System.out.println(new String(buf,0,temp));
            */

            //方式五 推荐使用：读入到字符数组的优化
            //由于有时候文件太大，无法确定需要定义的数组大小
            //因此一般定义数组长度为1024，采用循环的方式读入
            char[] buf = new char[1024];
            int temp = 0;
            // 将字符读入数组。返回：读取的字符数，如果已到达流的末尾，则返回 -1
            while((temp = r.read(buf)) != -1) {
                /**
                 * 通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String。新 String 的长度是字符集的函数，因此可能不等于该子数组的长度。
                 * bytes - 要解码为字符的 byte
                 * offset - 要解码的第一个 byte 的索引
                 * length - 要解码的 byte 数
                 */
                System.out.print(new String(buf,0,temp));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(r != null) {
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
