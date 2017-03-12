package list;

/**
 * Created by yandi on 2017/2/15.
 */
import java.util.ArrayList;
import java.util.List;

public class Sublist {

    public List<Integer> paging(List list,int pagesize){

        int totalcount=list.size();
        int pagecount=0;
        int m=totalcount%pagesize;
        if  (m>0){
            pagecount=totalcount/pagesize+1;
        }else{
            pagecount=totalcount/pagesize;
        }

        for(int i=1;i<=pagecount;i++){
            if (m==0){
                List<Integer> subList= list.subList((i-1)*pagesize,pagesize*(i));
                return subList;
            }else{
                if (i==pagecount){
                    List<Integer> subList= list.subList((i-1)*pagesize,totalcount);
                    return subList;
                }else{
                    List<Integer> subList= list.subList((i-1)*pagesize,pagesize*(i));
                    return subList;
                }


            }
        }
        return null;
    }


    public void PagingTest(List<Integer> list){
        for(int i=0; i<list.size(); i+=5) {
            List<Integer> needPoiAreaSubList = list.subList(i, Math.min(list.size(), i + 5));
            System.out.println(needPoiAreaSubList);
        }
    }

    public static void main(String[] args) {



        List<Integer> list=new ArrayList<Integer>();
        for(int i=1;i<26;i++){
            list.add(i);
        }

        System.out.println(new Sublist().paging(list, 10));
        System.out.println("----------------");
        new Sublist().PagingTest(list);
    }

}
