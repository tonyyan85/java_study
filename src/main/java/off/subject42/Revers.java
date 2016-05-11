package off.subject42;

/**
 * Created by yan on 2016/4/21.
 */
public class Revers {

    public static String getRevers(String str){
        String[] strs = str.split(" ");
        int length = strs.length;
        StringBuffer sb = new StringBuffer(length);
        for(int i =strs.length-1;i>=0;i--){
            sb.append(strs[i]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String args[]){
        System.out.println(getRevers("I am a student.").trim());
    }
}
