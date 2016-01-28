package bigFileIo;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;

/**
 * 我们只需要遍历文件的每一行，然后做相应的处理，处理完之后把它扔掉。
 * <p/>
 * 所以，这正是我们将要做的——通过行迭代，而不是把所有行都放在内存中。
 * Created by yan on 2016/1/28.
 */
public class ApacheCommonsIo {

    public static void main(String args[]) throws IOException {
        String file = "D:\\google.py";
        LineIterator it = FileUtils.lineIterator(new File(file), "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                System.out.println(line);
                // do something with line
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LineIterator.closeQuietly(it);
        }
    }

}
