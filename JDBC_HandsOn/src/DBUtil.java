import java.sql.*;

public class DBUtil {

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/XEPDB1",
                    "system",
                    "Sky2307");

        } catch (Exception e) {

            System.out.println(e);

        }

        return con;
    }
}