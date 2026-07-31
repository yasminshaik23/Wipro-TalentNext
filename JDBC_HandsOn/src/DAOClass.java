import java.sql.*;

public class DAOClass {

    Connection con;

    public DAOClass() {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/XEPDB1",
                    "system",
                    "Sky2307");

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void testConnection() {

        if (con != null)
            System.out.println("Connection Established Successfully");
        else
            System.out.println("Connection Failed");

    }

    public void insert(int rollNo, String studentName,
                   String standard, String dob, double fees) {

    try {

        String query = "INSERT INTO Student VALUES (?, ?, ?, TO_DATE(?, 'DD-MM-YYYY'), ?)";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, rollNo);
        ps.setString(2, studentName);
        ps.setString(3, standard);
        ps.setString(4, dob);
        ps.setDouble(5, fees);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Record Inserted Successfully");
        else
            System.out.println("Insertion Failed");

        ps.close();

    } catch (Exception e) {

        System.out.println(e);

    }
}
public void delete(int rollNo) {

    try {

        
        String insertLog = "INSERT INTO StudentLog (RollNo, StudentName, Standard, Leaving_Date) " +
                           "SELECT RollNo, StudentName, Standard, SYSDATE FROM Student WHERE RollNo=?";

        PreparedStatement ps1 = con.prepareStatement(insertLog);
        ps1.setInt(1, rollNo);
        ps1.executeUpdate();

        
        String deleteStudent = "DELETE FROM Student WHERE RollNo=?";

        PreparedStatement ps2 = con.prepareStatement(deleteStudent);
        ps2.setInt(1, rollNo);

        int rows = ps2.executeUpdate();

        if (rows > 0)
            System.out.println("Record Deleted Successfully");
        else
            System.out.println("Record Not Found");

        ps1.close();
        ps2.close();

    } catch (Exception e) {

        System.out.println(e);

    }

}
public void modify(int rollNo, double fees) {

    try {

        String query = "UPDATE Student SET Fees=? WHERE RollNo=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setDouble(1, fees);
        ps.setInt(2, rollNo);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Record Updated Successfully");
        else
            System.out.println("Record Not Found");

        ps.close();

    } catch (Exception e) {

        System.out.println(e);

    }

}
public void display(int rollNo) {

    try {

        String query = "SELECT * FROM Student WHERE RollNo=?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, rollNo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            System.out.println(
                    rs.getInt("RollNo") + "\t" +
                    rs.getString("StudentName") + "\t" +
                    rs.getString("Standard") + "\t" +
                    rs.getDate("Date_Of_Birth") + "\t" +
                    rs.getDouble("Fees"));

        } else {

            System.out.println("Record Not Found");

        }

        rs.close();
        ps.close();

    } catch (Exception e) {

        System.out.println(e);

    }

}
public void display() {

    try {

        String query = "SELECT * FROM Student";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            System.out.println(
                    rs.getInt("RollNo") + "\t" +
                    rs.getString("StudentName") + "\t" +
                    rs.getString("Standard") + "\t" +
                    rs.getDate("Date_Of_Birth") + "\t" +
                    rs.getDouble("Fees"));

        }

        rs.close();
        ps.close();

    } catch (Exception e) {

        System.out.println(e);

    }

}

}

