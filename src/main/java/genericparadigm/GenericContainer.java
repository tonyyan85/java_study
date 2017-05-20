package genericparadigm;

/**
 * Created by yandi on 2017/5/9.
 */
public class GenericContainer<T> {
    T type;


    public GenericContainer(T type) {
        this.type = type;
    }

    public <N> N add(N a){

        return a;
    }



}
