package dubbo.spi;

import java.util.ServiceLoader;

/**
 * Created by czadmin on 2016/12/5.
 */
public class SPIMain {
    public static void main(String[] args) {

        ServiceLoader<HelloInterface> loaders =
                ServiceLoader.load(HelloInterface.class);

        for (HelloInterface in : loaders) {
            in.sayHello();
        }
    }
}
