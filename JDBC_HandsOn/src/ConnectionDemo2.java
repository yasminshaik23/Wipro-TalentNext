import java.sql.*;

public class ConnectionDemo2 {

    public static void main(String[] args) {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/XEPDB1",
                    "system",
                    "Sky2307");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "SELECT employee_id, first_name FROM employees");

            while (rs.next()) {

                System.out.println(rs.getInt(1) + "\t" +
                                   rs.getString("first_name"));

            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {

            System.out.println(e);

        }
    }
}