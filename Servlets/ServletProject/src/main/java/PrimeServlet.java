package com.example;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        int number = Integer.parseInt(
                request.getParameter("number"));

        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i < number; i++) {

            boolean isPrime = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {

                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(i);
            }
        }

        request.setAttribute("primes", primes);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("primes.jsp");

        dispatcher.forward(request, response);
    }
}