package com.example.ejbtutorial;

import com.example.ejb.LoggerBean;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/logger")
public class LoggerServlet extends HttpServlet {

    @EJB
    private LoggerBean loggerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        if (action != null) {
            loggerBean.logAction(action);
            resp.getWriter().println("Action Logged: " + action);
        } else {
            resp.getWriter().println("No action specified");
        }
    }
}
