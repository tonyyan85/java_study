package weixin;

/**
 * Created by czadmin on 2016/9/19.
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class HttpUtils_touxiang {
    public HttpUtils_touxiang() {

    }

    public static void getJsonContent(String url_path){


        try {
            URL url = new URL(url_path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setConnectTimeout(3000);
            connection.setRequestMethod("GET");

            connection.setDoInput(true);

            int code = connection.getResponseCode();
            if(code ==200){
                changeInputStream(connection.getInputStream());


            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    private static void changeInputStream(InputStream inputStream) {
        // TODO Auto-generated method stub
        String jsonString = "";
        String nickname = null;
        String headimgurl =null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int len = 0;
        byte[] data = new byte[1024];
        try {
            while((len = inputStream.read(data))!=-1){

                outputStream.write(data,0,len);
            }
            jsonString = new String(outputStream.toByteArray(),"UTF-8");
            String mgs = new String(jsonString.getBytes("ISO-8859-1"),"UTF-8");
            System.out.println("mgs-----"+mgs);
            String mgstmp = new String(jsonString.getBytes(),"UTF-8");
            System.out.println("mgstmp-----"+mgstmp);
            String str = new String("focus .".getBytes(),"UTF-8");
            System.out.println("str="+str);
            //到这里已经是乱码了
            System.out.println("先前返回的是："+jsonString);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonString);
            System.out.println("返回的是:"+jsonObject);
            nickname = jsonObject.getString("nickname").toString();
            headimgurl = jsonObject.getString("headimgurl");

            System.out.println("你的昵称是："+nickname);

            System.out.println("过滤后的昵称："+containsEmoji(nickname).trim());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /**
     * 检测是否有emoji表情
     *
     * @param source
     * @return
     */
    public static String containsEmoji(String source) {
        int len = source.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (!isEmojiCharacter(codePoint)) { //如果不能匹配,则该字符是Emoji表情
                sb.append(" ");
            }else{
                sb.append(codePoint);
            }
        }
        return sb.toString();
    }

    /**
     * 判断是否是Emoji
     *
     * @param codePoint 比较的单个字符
     * @return
     */
    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) ||
                (codePoint == 0xD) || ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || ((codePoint >= 0x10000)
                && (codePoint <= 0x10FFFF));
    }

    public static  void main(String args[]){
        getJsonContent("https://api.weixin.qq.com/sns/userinfo?access_token=eksiGwbRQf4sYglm-4a0L0ozRlWr7djhAg_wZAxTJfL_X7Zc66OFTujBJM1iSgrRu6Dm9lglqi6Led7CIZC-Honhv6urxjhd3LfxDwzknr4&openid=oC5xgwIhSWs_MXCnhNxaWuI3J4c8&lang=zh_CN");
    }

}
