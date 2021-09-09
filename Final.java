package com.seek;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "Final", value = "/Final")
public class Final extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        class ConnectionTest {
            public void main(String[] args) throws Exception {

                // register Oracle thin driver with DriverManager service
                // It is optional for JDBC4.x version
                Class.forName("com.mysql.cj.jdbc.Driver");

                // variables
                final String url = "jdbc:mysql:///knowprogram";
                final String user = "root";
                final String password = "Password@0";

                // establish the connection
                Connection con = DriverManager.getConnection(url, user, password);

                // display status message
                if (con == null) {
                    System.out.println("JDBC connection is not established");
                    return;
                } else
                    System.out.println("Congratulations," +
                            " JDBC connection is established successfully.\n");

                // close JDBC connection
                con.close();

            }
        }
    }
}