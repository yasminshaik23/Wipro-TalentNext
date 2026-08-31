package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final String URL =
            "jdbc:oracle:thin:@//localhost:1521/XEPDB1";

    private static final String DB_USER = "SYSTEM";
    private static final String DB_PASSWORD = "Sky2307";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("retypePassword");

        // Server-side validation
        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            retypePassword == null || retypePassword.trim().isEmpty()) {

            request.setAttribute(
                    "message",
                    "All fields are required."
            );

            request.getRequestDispatcher("registerResult.jsp")
                   .forward(request, response);

            return;
        }

        if (!password.equals(retypePassword)) {

            request.setAttribute(
                    "message",
                    "Password and Retype Password should be same."
            );

            request.getRequestDispatcher("registerResult.jsp")
                   .forward(request, response);

            return;
        }

        String sql =
                "INSERT INTO login_users (username, password) VALUES (?, ?)";

        try {

            Class.forName("oracle.jdbc.OracleDriver");

            try (Connection connection =
                         DriverManager.getConnection(
                                 URL,
                                 DB_USER,
                                 DB_PASSWORD);

                 PreparedStatement statement =
                         connection.prepareStatement(sql)) {

                statement.setString(1, username);
                statement.setString(2, password);

                statement.executeUpdate();
            }

            response.sendRedirect("login.jsp");

        } catch (Exception e) {

            throw new ServletException(
                    "Registration error: " + e.getMessage(), e
            );
        }
    }
}