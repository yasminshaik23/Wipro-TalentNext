package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeInsertServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        String designation = request.getParameter("designation");

        String sql = "INSERT INTO employee (name, id, designation) VALUES (?, ?, ?)";

        response.setContentType("text/html");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, id);
            ps.setString(3, designation);

            int result = ps.executeUpdate();

            if (result > 0) {
                response.getWriter().println(
                    "<h2>Employee inserted successfully!</h2>"
                );
            }

            ps.close();
            con.close();

        } catch (Exception e) {

            response.getWriter().println(
                "<h2>Error inserting employee</h2>"
            );

            response.getWriter().println(
                "<p>" + e.getMessage() + "</p>"
            );
        }
    }
}