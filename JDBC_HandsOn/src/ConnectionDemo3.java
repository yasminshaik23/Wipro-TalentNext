import java.sql.*;

public class ConnectionDemo3 {

    public static void main(String[] args) {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/XEPDB1",
                    "system",
                    "Sky2307");

            Statement stmt = con.createStatement();

            String query = "SELECT first_name, job_id, salary, commission_pct " +
                           "FROM employees " +
                           "WHERE salary > 1000 AND salary < 2000";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                System.out.println(
                        rs.getString("first_name") + "\t" +
                        rs.getString("job_id") + "\t" +
                        rs.getDouble("salary") + "\t" +
                        rs.getString("commission_pct"));

            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {

            System.out.println(e);

        }
    }
}