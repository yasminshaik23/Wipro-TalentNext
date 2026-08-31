package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/validateEmail")
public class EmailValidationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");

        String email = request.getParameter("email");

        PrintWriter out = response.getWriter();

        String sql = "SELECT EMAIL FROM XYZ_PROFILE WHERE EMAIL = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    out.print("Email already exists!");
                } else {
                    out.print("Email available");
                }
            }

        } catch (Exception e) {
            out.print("Database error");
            e.printStackTrace();
        }
    }
}