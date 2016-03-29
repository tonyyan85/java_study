package string;

/**
 * Created by yan on 2016/3/29.
 * 空格替换
 */
public class ReplaceBlank {

    public String replaceBlank (String str){

        // 设定长度防止expandCapacity
        int count = 0;
        for(int i = 0 ;i<str.length();i++){
            if(str.charAt(i) == ' ')
                count++;
        }

        StringBuffer sb = new StringBuffer(str.length()+count*2);

        for(int i = 0 ;i<str.length();i++){
            if(str.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String args[]){
        System.out.println(new ReplaceBlank().replaceBlank("we are happy"));
    }

}
