import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * 字符串去重
 * Created by yan on 2016/1/30.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        long time = 0;
//        time = TimeUtils.printTime();//这是我的工具类，直接输出当前的时间
//          produceWord(1000000);
        try {

            BufferedReader br = new BufferedReader(new FileReader(FileUtils.getFile("word.txt")));
            FileWriter fw = new FileWriter(FileUtils.getFile("treeWord.txt"),true);
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            String s = null;
            while((s=br.readLine())!=null){
                if(!hm.containsKey(s)){  //如果hm没有包含s这个单词，则把s加入到hm，同时写入文件treeWord.txt中
                    hm.put(s, 1);
                    //输出到文件
                    fw.write(s);
                    fw.write("\r\n");
                    fw.flush();
                }

            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        time = TimeUtils.printTime()-time;
//        TimeUtils.takeTime(time);//总共花费了多少秒
    }
}
