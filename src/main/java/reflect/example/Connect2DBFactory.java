package reflect.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect2DBFactory {
    public static Connection getDBConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/blogsystem";
            String user = "root";
            String password = "netjava";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
