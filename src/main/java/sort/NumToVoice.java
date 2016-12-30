package sort;

import java.io.UnsupportedEncodingException;

/**
 * Created by czadmin on 2016/12/30.
 */
public class NumToVoice {

    public String num2Voice(int num){
        //        String[] str = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String[] str = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
//        String ss[] = new String[] { "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿" };
        String ss[] = new String[] { "个", "十", "百", "千", "万", "十", "百", "千", "亿" };
        String s = String.valueOf(num);
        System.out.println(s);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            String index = String.valueOf(s.charAt(i));
            sb = sb.append(str[Integer.parseInt(index)]);
        }
        String sss = String.valueOf(sb);
        System.out.println(sss);
        int i = 0;
        for (int j = sss.length(); j > 0; j--) {
            sb = sb.insert(j, ss[i++]);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println( new NumToVoice().num2Voice(5656));
//        test(912321321);
    }
}
