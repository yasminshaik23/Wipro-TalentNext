package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/bid")
public class BidServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String itemId = request.getParameter("itemId");
        String itemName = request.getParameter("itemName");
        String bidderName = request.getParameter("bidderName");
        String email = request.getParameter("email");
        String bidAmount = request.getParameter("bidAmount");
        String autoIncrement = request.getParameter("autoIncrement");

        // Validate required fields
        if (isEmpty(itemId) ||
            isEmpty(itemName) ||
            isEmpty(bidderName) ||
            isEmpty(email) ||
            isEmpty(bidAmount)) {

            response.setContentType("text/html");

            response.getWriter().println(
                "<h2>Please fill all required fields.</h2>"
            );

            response.getWriter().println(
                "<a href='bid.html'>Go Back</a>"
            );

            return;
        }

        // Checkbox is optional
        if (autoIncrement == null) {
            autoIncrement = "No";
        }

        // Create JavaBean
        Bid bid = new Bid();

        bid.setItemId(itemId);
        bid.setItemName(itemName);
        bid.setBidderName(bidderName);
        bid.setEmail(email);
        bid.setBidAmount(bidAmount);
        bid.setAutoIncrement(autoIncrement);

        // Send bean to JSP
        request.setAttribute("bid", bid);

        request.getRequestDispatcher("bidResult.jsp")
               .forward(request, response);
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}