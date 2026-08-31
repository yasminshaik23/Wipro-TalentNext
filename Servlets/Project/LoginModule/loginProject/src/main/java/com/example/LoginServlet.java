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
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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

        String sql =
                "SELECT * FROM login_users " +
                "WHERE username = ? AND password = ?";

        try {
            Class.forName("oracle.jdbc.OracleDriver");

            try (Connection connection =
                         DriverManager.getConnection(
                                 URL, DB_USER, DB_PASSWORD);
                 PreparedStatement statement =
                         connection.prepareStatement(sql)) {

                statement.setString(1, username);
                statement.setString(2, password);

                try (ResultSet resultSet = statement.executeQuery()) {

                    if (resultSet.next()) {

                        request.setAttribute("username", username);

                        request.getRequestDispatcher("home.jsp")
                               .forward(request, response);

                    } else {

                        request.setAttribute(
                                "error",
                                "Invalid username or password."
                        );

                        request.getRequestDispatcher("login.jsp")
                               .forward(request, response);
                    }
                }
            }

        } catch (Exception e) {

            throw new ServletException(
                    "Database error: " + e.getMessage(), e
            );
        }
    }
}