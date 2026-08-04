import java.sql.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
public class UserDAO {

    public String getUserType(String userID) {

        String userType = null;

        try {

            Connection con = DBUtil.getConnection();

            String query = "SELECT UserType FROM USERS WHERE UserID=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, userID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                userType = rs.getString("UserType");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println(e);

        }

        return userType;

    }
    public String getIncorrectAttempts(String userID) {

    String message = "";

    try {

        Connection con = DBUtil.getConnection();

        String query = "SELECT IncorrectAttempts FROM USERS WHERE UserID=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, userID);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            int attempts = rs.getInt("IncorrectAttempts");

            if (attempts == 0)
                message = "No Incorrect Attempt";
            else if (attempts == 1)
                message = "One Time";
            else
                message = "Incorrect Attempt Exceeded";

        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {

        System.out.println(e);

    }

    return message;

}
public String changeUserType(String userID) {

    String message = "";

    try {

        Connection con = DBUtil.getConnection();

        String query = "UPDATE USERS SET UserType='Admin' WHERE UserID=? AND UserType='Employee'";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, userID);

        int rows = ps.executeUpdate();

        if (rows > 0)
            message = "User Type Changed Successfully";
        else
            message = "User is already Admin or UserID not found";

        ps.close();
        con.close();

    } catch (Exception e) {

        System.out.println(e);

    }

    return message;
}
public String getLockStatus(String userID) {

    String status = "";

    try {

        Connection con = DBUtil.getConnection();

        String query = "SELECT LockStatus FROM USERS WHERE UserID=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, userID);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            int lock = rs.getInt("LockStatus");

            if (lock == 0)
                status = "Unlocked";
            else
                status = "Locked";

        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {

        System.out.println(e);

    }

    return status;
}
public String changeName(String userID, String newName) {

    String message = "";

    try {

        Connection con = DBUtil.getConnection();

        String query = "UPDATE USERS SET Name=? WHERE UserID=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, newName);
        ps.setString(2, userID);

        int rows = ps.executeUpdate();

        if (rows > 0)
            message = "Name Updated Successfully";
        else
            message = "UserID Not Found";

        ps.close();
        con.close();

    } catch (Exception e) {

        System.out.println(e);

    }

    return message;
}
public String changePassword(String userID, String newPassword) {

    String message = "";

    try {

        Connection con = DBUtil.getConnection();

        String query = "UPDATE USERS SET Password=? WHERE UserID=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, newPassword);
        ps.setString(2, userID);

        int rows = ps.executeUpdate();

        if (rows > 0)
            message = "Password Updated Successfully";
        else
            message = "UserID Not Found";

        ps.close();
        con.close();

    } catch (Exception e) {

        System.out.println(e);

    }

    return message;
}
public String addUser_1(UserBean bean) {

    String message = "";

    try {

        Connection con = DBUtil.getConnection();

        Statement stmt = con.createStatement();

        String query = "INSERT INTO USERS VALUES('" +
                bean.getUserID() + "','" +
                bean.getPassword() + "','" +
                bean.getName() + "'," +
                bean.getIncorrectAttempts() + "," +
                bean.getLockStatus() + ",'" +
                bean.getUserType() + "')";

        int rows = stmt.executeUpdate(query);

        if (rows > 0)
            message = "User Added Successfully";
        else
            message = "Insertion Failed";

        stmt.close();
        con.close();

    } catch (Exception e) {

        System.out.println(e);

    }

    return message;
}

public String addUser_2(UserBean bean) {

    String message = "";

    try {

        Connection con = DBUtil.getConnection();

        String query = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, bean.getUserID());
        ps.setString(2, bean.getPassword());
        ps.setString(3, bean.getName());
        ps.setInt(4, bean.getIncorrectAttempts());
        ps.setInt(5, bean.getLockStatus());
        ps.setString(6, bean.getUserType());

        int rows = ps.executeUpdate();

        if (rows > 0)
            message = "User Added Successfully";
        else
            message = "Insertion Failed";

        ps.close();
        con.close();

    } catch (Exception e) {

        System.out.println(e);

    }

    return message;
}
public ArrayList<UserBean> getUsers() {

    ArrayList<UserBean> list = new ArrayList<>();

    try {

        Connection con = DBUtil.getConnection();

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");

        while (rs.next()) {

            UserBean bean = new UserBean();

            bean.setUserID(rs.getString("UserID"));
            bean.setPassword(rs.getString("Password"));
            bean.setName(rs.getString("Name"));
            bean.setIncorrectAttempts(rs.getInt("IncorrectAttempts"));
            bean.setLockStatus(rs.getInt("LockStatus"));
            bean.setUserType(rs.getString("UserType"));

            list.add(bean);

        }

        rs.close();
        stmt.close();
        con.close();

    } catch (Exception e) {

        System.out.println(e);

    }

    return list;

}
public String storeAllRecords() {

    String message = "";

    try {

        Connection con = DBUtil.getConnection();

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");

        PrintWriter pw = new PrintWriter(new FileWriter("Users.txt"));

        while (rs.next()) {

            pw.println(
                    rs.getString("UserID") + "\t" +
                    rs.getString("Password") + "\t" +
                    rs.getString("Name") + "\t" +
                    rs.getInt("IncorrectAttempts") + "\t" +
                    rs.getInt("LockStatus") + "\t" +
                    rs.getString("UserType"));

        }

        pw.close();
        rs.close();
        stmt.close();
        con.close();

        message = "Records Stored Successfully";

    } catch (Exception e) {

        System.out.println(e);

    }

    return message;
}
public ArrayList<String> getNames() {

    ArrayList<String> list = new ArrayList<>();

    try {

        Connection con = DBUtil.getConnection();

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT Name FROM USERS");

        while (rs.next()) {

            list.add(rs.getString("Name"));

        }

        rs.close();
        stmt.close();
        con.close();

    } catch (Exception e) {

        System.out.println(e);

    }

    return list;
}

}