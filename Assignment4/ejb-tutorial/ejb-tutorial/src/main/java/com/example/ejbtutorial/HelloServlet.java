package com.example.ejbtutorial;

import com.example.ejb.CalculatorBean;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @EJB
    private CalculatorBean calculatorBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int a = 20;
        int b = 5;
        int sum = calculatorBean.add(a, b);
        int diff = calculatorBean.subtract(a, b);
        int prod = calculatorBean.multiply(a, b);
        int quot = calculatorBean.divide(a, b);

        response.setContentType("text/plain");
        response.getWriter().println(a + " + " + b + " = " + sum);
        response.getWriter().println(a + " - " + b + " = " + diff);
        response.getWriter().println(a + " * " + b + " = " + prod);
        response.getWriter().println(a + " / " + b + " = " + quot);
    }
}
