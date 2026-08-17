package com.example;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/operation")
public class OperationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String value = request.getParameter("operation");

        if (value == null || value.trim().isEmpty()) {
            RequestDispatcher rd =
                    request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
            return;
        }

        try {
            int operation = Integer.parseInt(value);

            if (operation < 10) {

                RequestDispatcher rd =
                        request.getRequestDispatcher("page1.jsp");
                rd.forward(request, response);

            } else if (operation > 10 && operation < 99) {

                RequestDispatcher rd =
                        request.getRequestDispatcher("page2.jsp");
                rd.forward(request, response);

            } else {

                RequestDispatcher rd =
                        request.getRequestDispatcher("error.jsp");
                rd.forward(request, response);
            }

        } catch (NumberFormatException e) {

            RequestDispatcher rd =
                    request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}