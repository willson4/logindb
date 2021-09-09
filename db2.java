package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


@WebServlet(name = "", value = "/")
public class db2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matno = String.valueOf(request.getParameter("mat"));
        String password = request.getParameter("pass");

        RegisterBean registerBean = new RegisterBean();
        registerBean.setMatno(matno);
        registerBean.setPassword(password);

        RegisterDao registerDao = new RegisterDao();
        String userRegistered = registerDao.registerUser(registerBean);
        if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
        {
            request.getRequestDispatcher("/sample.jsp").forward(request, response);
        }
        else   //On Failure, display a meaningful message to the User.
        {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}

