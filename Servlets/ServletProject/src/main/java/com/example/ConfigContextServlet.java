package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/config-context",
    initParams = {
        @jakarta.servlet.annotation.WebInitParam(
            name = "studentName",
            value = "Shaik"
        ),
        @jakarta.servlet.annotation.WebInitParam(
            name = "course",
            value = "Java Servlet"
        )
    }
)
public class ConfigContextServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // ServletConfig
        ServletConfig config = getServletConfig();

        String studentName = config.getInitParameter("studentName");
        String course = config.getInitParameter("course");

        // ServletContext
        ServletContext context = getServletContext();

        String college = context.getInitParameter("college");
        String application = context.getInitParameter("application");

        out.println("<html>");
        out.println("<head><title>Servlet Config and Context</title></head>");
        out.println("<body>");

        out.println("<h1>Servlet Config Parameters</h1>");

        out.println("<p>Student Name: " + studentName + "</p>");
        out.println("<p>Course: " + course + "</p>");

        out.println("<h1>Servlet Context Parameters</h1>");

        out.println("<p>College: " + college + "</p>");
        out.println("<p>Application: " + application + "</p>");

        out.println("</body>");
        out.println("</html>");
    }
}