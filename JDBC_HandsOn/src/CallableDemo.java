import java.sql.*;

public class CallableDemo {

    public static void main(String[] args) {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/XEPDB1",
                    "system",
                    "Sky2307");

            int empNo = Integer.parseInt(args[0]);

            CallableStatement cs = con.prepareCall("{call CALC_NETSAL(?, ?)}");

            cs.setInt(1, empNo);

            cs.registerOutParameter(2, Types.DOUBLE);

            cs.execute();

          
            double netSalary = cs.getDouble(2);

            System.out.println("Employee Number : " + empNo);
            System.out.println("Net Salary      : " + netSalary);

          
            cs.close();
            con.close();

        } catch (Exception e) {

            System.out.println(e);

        }

    }
}