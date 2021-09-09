package com.seek;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "first", value = "/first")
public class first extends HttpServlet {
    public first(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String MATNO = String.valueOf(request.getParameter("mat"));
            String password = request.getParameter("pass");


        System.out.println(MATNO + password + "userdetails");

                 if (password != null || MATNO !=null){
                     RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
                     requestDispatcher.forward(request, response);
                 }else{
                     RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                     requestDispatcher.forward(request, response);
                 }
    }
}
