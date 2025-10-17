package Library_Management;
import java.sql.*;
public class DBConnection {

    public static Connection getConnection() {
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root","1312");
        } catch (Exception e) {
            System.out.println("DB class not found" + e.getMessage());
        }
        return con;
    }
}
