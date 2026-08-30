package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {

    private static final String URL =
            "jdbc:oracle:thin:@//localhost:1521/XEPDB1";

    private static final String USER = "SYSTEM";

    private static final String PASSWORD =
            "Sky2307";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String userid = request.getParameter("userid");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword =
                request.getParameter("confirmPassword");

        response.setContentType("text/html");

        if (!newPassword.equals(confirmPassword)) {
            response.getWriter().println(
                "<h3>New Password and Confirm Password do not match</h3>");
            response.getWriter().println(
                "<a href='changePassword.html'>Try Again</a>");
            return;
        }

        try {

            Class.forName("oracle.jdbc.OracleDriver");

            Connection con =
                    DriverManager.getConnection(
                            URL, USER, PASSWORD);

            // Check old password
            String checkSql =
                    "SELECT userid FROM servlet_users " +
                    "WHERE userid = ? AND password = ?";

            PreparedStatement checkPs =
                    con.prepareStatement(checkSql);

            checkPs.setString(1, userid);
            checkPs.setString(2, oldPassword);

            ResultSet rs = checkPs.executeQuery();

            if (!rs.next()) {

                response.getWriter().println(
                    "<h3>Invalid UserID or Old Password</h3>");

                response.getWriter().println(
                    "<a href='changePassword.html'>Try Again</a>");

            } else {

                // Update password
                String updateSql =
                        "UPDATE servlet_users " +
                        "SET password = ? " +
                        "WHERE userid = ?";

                PreparedStatement updatePs =
                        con.prepareStatement(updateSql);

                updatePs.setString(1, newPassword);
                updatePs.setString(2, userid);

                updatePs.executeUpdate();

                updatePs.close();

                response.getWriter().println(
                    "<h3>Password Changed Successfully</h3>");

                response.getWriter().println(
                    "<a href='login.html'>Go to Login</a>");
            }

            rs.close();
            checkPs.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                "<h3>Database error: "
                + e.getMessage()
                + "</h3>");
        }
    }
}