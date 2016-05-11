package io;

/**
 * Created by Administrator on 2016/5/11.
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
class ResourceHelper {
    /**
     * @param resourceName
     * @return
     * @return
     */
    static BufferedInputStream getResourceInputStream(String resourceName) {
        try {
            return new BufferedInputStream(new FileInputStream(resourceName));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
