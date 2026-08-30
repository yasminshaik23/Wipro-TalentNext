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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String URL =
            "jdbc:oracle:thin:@//localhost:1521/XEPDB1";

    private static final String USER = "SYSTEM";

    private static final String PASSWORD =
            "Sky2307";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        String sql =
            "SELECT userid FROM servlet_users " +
            "WHERE userid = ? AND password = ?";

        try {

            Class.forName("oracle.jdbc.OracleDriver");

            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, userid);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                response.sendRedirect(
                        "home.jsp?userid=" + userid);

            } else {

                response.setContentType("text/html");

                response.getWriter().println(
                    "<h3>Invalid UserID or Password</h3>");

                response.getWriter().println(
                    "<a href='login.html'>Back to Login</a>");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

            response.setContentType("text/html");

            response.getWriter().println(
                "Database error: " + e.getMessage());
        }
    }
}