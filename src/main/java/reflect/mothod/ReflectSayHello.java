package reflect.mothod;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by yan on 2016/3/27.
 */
public class ReflectSayHello {
    public static void main(String args[]){
        Class claz = SayHello.class;
        try {
            SayHello obj = (SayHello) claz.newInstance();
            Method method = claz.getMethod("sayHello",String.class);

            System.out.println(method.invoke(obj, "123213"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
