package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Get or create session
        HttpSession session = request.getSession();

        // Get visit count
        Integer visitCount =
                (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }

        // Store updated count
        session.setAttribute("visitCount", visitCount);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Session Tracking</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Session Tracking</h1>");

        out.println("<h2>Session Details</h2>");

        out.println("<p><b>Number of visits:</b> "
                + visitCount + "</p>");

        out.println("<p><b>Session ID:</b> "
                + session.getId() + "</p>");

        out.println("<p><b>Creation Time:</b> "
                + new Date(session.getCreationTime()) + "</p>");

        out.println("<p><b>Last Accessed Time:</b> "
                + new Date(session.getLastAccessedTime()) + "</p>");

        out.println("<p><b>Maximum Inactive Interval:</b> "
                + session.getMaxInactiveInterval()
                + " seconds</p>");

        out.println("<p><b>Is New Session:</b> "
                + session.isNew() + "</p>");

        out.println("</body>");
        out.println("</html>");
    }
}