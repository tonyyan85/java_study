package sort;

import java.io.UnsupportedEncodingException;

/**
 * Created by czadmin on 2016/12/30.
 */
public class NumToVoice {

    public String num2Voice(int num){
        //        String[] str = { "��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��" };
        String[] str = { "��", "һ", "��", "��", "��", "��", "��", "��", "��", "��" };
//        String ss[] = new String[] { "Ԫ", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��" };
        String ss[] = new String[] { "��", "ʮ", "��", "ǧ", "��", "ʮ", "��", "ǧ", "��" };
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
