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

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {

    private static final String URL =
            "jdbc:oracle:thin:@//localhost:1521/XEPDB1";

    private static final String DB_USER = "SYSTEM";
    private static final String DB_PASSWORD = "Sky2307";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String retypePassword = request.getParameter("retypePassword");

        // Validate fields
        if (username == null || username.trim().isEmpty() ||
            oldPassword == null || oldPassword.trim().isEmpty() ||
            newPassword == null || newPassword.trim().isEmpty() ||
            retypePassword == null || retypePassword.trim().isEmpty()) {

            request.setAttribute(
                    "message",
                    "All fields are required."
            );

            request.getRequestDispatcher("changePasswordResult.jsp")
                   .forward(request, response);

            return;
        }

        // Check new passwords
        if (!newPassword.equals(retypePassword)) {

            request.setAttribute(
                    "message",
                    "New Password and Retype Password should be same."
            );

            request.getRequestDispatcher("changePasswordResult.jsp")
                   .forward(request, response);

            return;
        }

        try {

            Class.forName("oracle.jdbc.OracleDriver");

            try (Connection connection =
                         DriverManager.getConnection(
                                 URL,
                                 DB_USER,
                                 DB_PASSWORD)) {

                // Verify username and old password
                String checkSql =
                        "SELECT username FROM login_users " +
                        "WHERE username = ? AND password = ?";

                try (PreparedStatement checkStatement =
                             connection.prepareStatement(checkSql)) {

                    checkStatement.setString(1, username);
                    checkStatement.setString(2, oldPassword);

                    try (ResultSet resultSet =
                                 checkStatement.executeQuery()) {

                        if (!resultSet.next()) {

                            request.setAttribute(
                                    "message",
                                    "Invalid username or old password."
                            );

                            request.getRequestDispatcher(
                                    "changePasswordResult.jsp"
                            ).forward(request, response);

                            return;
                        }
                    }
                }

                // Update password
                String updateSql =
                        "UPDATE login_users " +
                        "SET password = ? " +
                        "WHERE username = ?";

                try (PreparedStatement updateStatement =
                             connection.prepareStatement(updateSql)) {

                    updateStatement.setString(1, newPassword);
                    updateStatement.setString(2, username);

                    updateStatement.executeUpdate();
                }
            }

            request.setAttribute(
                    "message",
                    "Password changed successfully."
            );

            request.getRequestDispatcher(
                    "changePasswordResult.jsp"
            ).forward(request, response);

        } catch (Exception e) {

            throw new ServletException(
                    "Password change error: " + e.getMessage(), e
            );
        }
    }
}