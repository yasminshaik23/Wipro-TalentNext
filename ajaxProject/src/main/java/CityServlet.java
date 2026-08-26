package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cities")
public class CityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");

        String state = request.getParameter("state");

        PrintWriter out = response.getWriter();

        if ("Andhra Pradesh".equals(state)) {

            out.println("Visakhapatnam, Vijayawada, Tirupati");

        } else if ("Tamil Nadu".equals(state)) {

            out.println("Chennai, Coimbatore, Madurai");

        } else if ("Karnataka".equals(state)) {

            out.println("Bengaluru, Mysuru, Mangaluru");

        } else if ("Telangana".equals(state)) {

            out.println("Hyderabad, Warangal, Nizamabad");

        } else {

            out.println("No cities available");
        }
    }
}