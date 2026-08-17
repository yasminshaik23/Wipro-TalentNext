package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstVisitServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        boolean visited = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visited")) {
                    visited = true;
                    break;
                }
            }
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Visit Page</title>");
        out.println("</head>");
        out.println("<body>");

        if (!visited) {

            out.println("<h1>Welcome, you are visiting for the first time</h1>");

            Cookie visitCookie = new Cookie("visited", "yes");
            visitCookie.setMaxAge(60 * 60 * 24 * 30);

            response.addCookie(visitCookie);

        } else {

            out.println("<h1>Welcome Back</h1>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}