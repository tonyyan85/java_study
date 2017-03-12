package map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yandi on 2017/2/14.
 */
public class HashMapTest {
    public static void main(String args[]){
        Map<String,String> hash = null;
        for (Map.Entry<String,String> entry : hash.entrySet()){
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        }
    }
}
