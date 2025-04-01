package com.example.lab11;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    @EJB
    private CalculatorBean calculatorBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        int a = 10;
        int b = 2;

        out.println("<h1>CalculatorBean EJB Results</h1>");
        out.println("<p>Add: " + calculatorBean.add(a, b) + "</p>");
        out.println("<p>Subtract: " + calculatorBean.subtract(a, b) + "</p>");
        out.println("<p>Multiply: " + calculatorBean.multiply(a, b) + "</p>");
        out.println("<p>Divide: " + calculatorBean.divide(a, b) + "</p>");
    }
}
