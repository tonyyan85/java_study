package hashMapException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/11.
 */
public class HashMapRemoveException {
    public static void main(String args[]){
        Map<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("1","1");
        hashMap.put("2","2");
        hashMap.put("3","3");


//        for (Map.Entry<String, String> entry : hashMap.entrySet()){
//            System.out.println(entry.getKey());
//            hashMap.remove(entry.getKey());
//        }


        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key);
            iterator.remove();
        }

        System.out.println(hashMap.size());
    }
}
