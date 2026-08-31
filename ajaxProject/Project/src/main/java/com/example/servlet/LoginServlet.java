package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String sql = "SELECT EMAIL FROM XYZ_PROFILE " +
                     "WHERE EMAIL = ? AND PASSWORD = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    response.sendRedirect("home.html");
                } else {
                    response.setContentType("text/html");
                    response.getWriter().println(
                        "<h3>Invalid email or password</h3>"
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

            response.setContentType("text/plain");
            response.getWriter().println("Database error");
        }
    }
}