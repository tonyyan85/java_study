package dubbo.spi.impl;

import dubbo.spi.HelloInterface;

/**
 * Created by czadmin on 2016/12/5.
 */
public class TextHello implements HelloInterface {
    public void sayHello() {
        System.out.println("Text Hello.");
    }
}
