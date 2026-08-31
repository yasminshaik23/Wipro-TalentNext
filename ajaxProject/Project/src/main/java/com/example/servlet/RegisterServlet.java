package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String occupation = request.getParameter("occupation");
        String city = request.getParameter("city");
        String mobile = request.getParameter("mobile");

        String sql = "INSERT INTO XYZ_PROFILE " +
                "(EMAIL, PASSWORD, NAME, DOB, GENDER, OCCUPATION, CITY, MOBILE) " +
                "VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, dob);
            ps.setString(5, gender);
            ps.setString(6, occupation);
            ps.setString(7, city);
            ps.setString(8, mobile);

            ps.executeUpdate();

            response.sendRedirect("login.html");

        } catch (Exception e) {
            e.printStackTrace();

            response.setContentType("text/plain");
            response.getWriter().println("Registration failed");
        }
    }
}