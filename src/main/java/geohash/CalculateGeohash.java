package geohash;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yandi on 2017/4/22.
 */
public class CalculateGeohash {

    public static void main(String args[]){
        double lat = 1.37;
        double lng = 2.75;
        double km = 304;
        int n = 16;

//        int math = 2;
//        for(int i =0;i < 10;i++){
//            n = n+1;
//            lat = lat / math;
//            lng = lng / math;
//            km = km / math;
//
//            System.out.println(n+","+String.valueOf(lat)+","+String.valueOf(lng)+","+String.valueOf(km));
//        }

        int math = 2;
        for(int i =0;i < 10;i++){
            n = n-1;
            lat = lat * math;
            lng = lng * math;
            km = km * math;

            System.out.println(n+","+String.valueOf(lat)+","+String.valueOf(lng)+","+String.valueOf(km));
        }


        List list  = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        new CalculateGeohash().test(list);
        new CalculateGeohash().test(list);
    }
    private void test(List list){
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.print(str);
            if("1"==str){
                iterator.remove();
            }
            System.out.println("");
        }
    }
}
