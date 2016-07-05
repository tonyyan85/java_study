package test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by czadmin on 2016/6/23.
 */
public class CalendarTest {
    public static void main(String args[]){
        Date releaseDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(releaseDate);
        c.add(Calendar.MONTH, 3);

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        System.out.println(c.getTime());
    }
}
