package bigFileIo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 这个方法不好用
 * 将一个行数为fileLines的文本文件平均分为splitNum个小文本文件，
 * 其中换行符'r'是linux上的，windows的java换行符是'\r\n'
 */

public class FileSplit
{
    public static void main(String[] args) throws IOException
    {
        long timer = System.currentTimeMillis();
        int bufferSize = 20 * 1024 * 1024;//设读取文件的缓存为20MB

        //建立缓冲文本输入流
        File file = new File("D://npMyEditBox.log");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
        BufferedReader input = new BufferedReader(inputStreamReader, bufferSize);

        int splitNum = 4-1;//要分割的块数减一
        int fileLines = 23;//输入文件的行数
        long perSplitLines = fileLines / splitNum;//每个块的行数
        for (int i = 0; i <= splitNum; ++i)
        {
            //分割
            //每个块建立一个输出
            FileWriter output = new FileWriter("D://" + i + ".txt");
            String line = null;
            //逐行读取，逐行输出
            for (long lineCounter = 0; lineCounter < perSplitLines && (line = input.readLine()) != null; ++lineCounter)
            {
                output.append(line + "\r");
            }
            output.flush();
            output.close();
            output = null;
        }
        input.close();
        timer = System.currentTimeMillis() - timer;
        System.out.println("处理时间：" + timer);
    }
}

