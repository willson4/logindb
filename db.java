package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "FirstConnection", value = "/FirstConnection")
public class db extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matno = String.valueOf(request.getParameter("mat"));
        String password = request.getParameter("pass");

        if (matno != null && password != null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("sample.jsp");
            requestDispatcher.forward(request , response);
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request , response);
        }
    }
}
