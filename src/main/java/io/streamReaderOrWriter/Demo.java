package io.streamReaderOrWriter;

/**
 * Created by Administrator on 2016/5/13.
 */
import java.io.*;

public class Demo {
    public static void main(String[] args) {
        readAndWriteCmd();
    }

    public static void readAndWriteCmd() {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufw= new BufferedWriter(new OutputStreamWriter(new
        // FileOutputStream("c:\\out.txt")));
        BufferedWriter bufw = null;
        try {
            bufw = new BufferedWriter(new FileWriter("c:\\out.txt"));
            String lineStr = null;
            while (true) {
                lineStr = bufr.readLine(); // 读取我们从键盘输入到控制台的内容
                if (lineStr != null) {
                    if (lineStr.equals("over")) // 输入over时结束
                    {
                        break;
                    } else {
                        bufw.write(lineStr);
                        bufw.newLine(); // 输出换行符,在windows里也可直接输出"\r\n"
                        bufw.flush(); // 清空缓冲区,否则下一次输出时会重复输出
                    }
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufr.close();
                bufw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}