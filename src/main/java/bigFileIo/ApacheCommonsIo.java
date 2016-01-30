package bigFileIo;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 我们只需要遍历文件的每一行，然后做相应的处理，处理完之后把它扔掉。
 * <p/>
 * 所以，这正是我们将要做的——通过行迭代，而不是把所有行都放在内存中。
 * Created by yan on 2016/1/28.
 */
public class ApacheCommonsIo {

    public static void main(String args[]) throws IOException {
        String filePath = "D://google.py";
        File file = new File(filePath);
        int lenght  = 10;
        LineIterator it = FileUtils.lineIterator(file, "UTF-8");
        for(int i =1;it.hasNext();i++){
            //分割
            //每个块建立一个输出
            FileWriter output = new FileWriter("D://" + i + ".txt");
            try {
                for (long lineCounter = 0; lineCounter < lenght
                        && it.hasNext(); ++lineCounter) {
                    String line = it.nextLine();
                    System.out.println(line);
                    output.append(line+"\r");
                    // do something with line
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                output.flush();
                output.close();
                output = null;

            }
        }
        LineIterator.closeQuietly(it);
    }


//    使用scanner
    public void tryScanner(String path) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // System.out.println(line);
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

}
