package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

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
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String state = request.getParameter("state");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");

        String sql =
            "INSERT INTO servlet_users " +
            "(userid, password, dob, gender, state, contact, address) " +
            "VALUES (?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?)";

        try {

            Class.forName("oracle.jdbc.OracleDriver");

            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, userid);
            ps.setString(2, password);
            ps.setString(3, dob);
            ps.setString(4, gender);
            ps.setString(5, state);
            ps.setString(6, contact);
            ps.setString(7, address);

            ps.executeUpdate();

            ps.close();
            con.close();

            response.sendRedirect("login.html");

        } catch (Exception e) {

            e.printStackTrace();

            response.setContentType("text/html");

            response.getWriter().println(
                "<h3>Registration failed: "
                + e.getMessage()
                + "</h3>"
            );

            response.getWriter().println(
                "<a href='registration.html'>Back to Registration</a>"
            );
        }
    }
}