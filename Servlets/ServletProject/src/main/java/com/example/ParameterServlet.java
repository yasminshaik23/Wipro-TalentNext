package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/parameters")
public class ParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        showParameters(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        showParameters(request, response);
    }

    private void showParameters(HttpServletRequest request,
                                HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Parameters</title></head>");
        out.println("<body>");

        out.println("<h1>Parameters Received</h1>");

        Enumeration<String> parameterNames =
                request.getParameterNames();

        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr>");
        out.println("<th>Parameter Name</th>");
        out.println("<th>Parameter Value</th>");
        out.println("</tr>");

        while (parameterNames.hasMoreElements()) {

            String name = parameterNames.nextElement();

            String[] values = request.getParameterValues(name);

            out.println("<tr>");
            out.println("<td>" + name + "</td>");
            out.println("<td>");

            if (values != null) {
                for (String value : values) {
                    out.println(value + "<br>");
                }
            }

            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}