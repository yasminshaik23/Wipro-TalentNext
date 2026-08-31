package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.io.PrintWriter;

@WebServlet("/dbTest")
public class DBTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();

        try (Connection con = DBConnection.getConnection()) {

            if (con != null) {
                out.println("Database connection successful!");
            }

        } catch (Exception e) {

            out.println("Database connection failed!");
            e.printStackTrace(out);
        }
    }
}