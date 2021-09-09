package com.seek;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@WebServlet(name = "second", value = "/second")
public class second extends HttpServlet {

    private String jdbcURL = "jdbc:mysql://localhost:3306/save?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "R&oot567";

    private static final String INSERT_USERS_SQL = "INSERT INTO students" + "  (firstname,lastname,email,age,state,country) VALUES "
            + " (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,firstname,lastname,email,age,state,country from student where id =?";
    private static final String SELECT_ALL_USERS = "select * from students";
    private static final String DELETE_USERS_SQL = "delete from students where id = ?;";
    private static final String UPDATE_USERS_SQL = "update students set firstname = ?,lastname = ?, email= ?, age = ?, state = ?, country =? where id = ?;";
    private Object User;

    public second(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String FIRSTNAME = request.getParameter("first");
        String LASTNAME = request.getParameter("last");
        String EMAIL = request.getParameter("email");
        Integer AGE = Integer.parseInt(request.getParameter("age"));
        String STATE_OF_BIRTH = request.getParameter("state");
        String COURSE_OF_STUDY = request.getParameter("course");


        if (FIRSTNAME != null && LASTNAME != null && EMAIL != null && AGE != null && STATE_OF_BIRTH != null && COURSE_OF_STUDY != null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("registered.jsp");
            requestDispatcher.forward(request, response);
        }else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
            requestDispatcher.forward(request, response);
        }

        try
        {
                insertLast(FIRSTNAME,LASTNAME,EMAIL,AGE,STATE_OF_BIRTH,COURSE_OF_STUDY);
        }
        catch(Exception e)
        {
            out.print(e);
            e.printStackTrace();
        }
    }


    protected Connection getConnection() throws SQLException {

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Remote connection successful.");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertLast(String firstname, String lastname, String email, Integer age, String state_of_birth, String course_of_study) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, String.valueOf(age));
            preparedStatement.setString(5, state_of_birth);
            preparedStatement.setString(6, course_of_study);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectLast(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname=   rs.getString("lastname");
                Integer age =      rs.getInt("age");
                String email=      rs.getString("email");
                String state=      rs.getString("state");
                String course=     rs.getString("course");
                User = new User(id,firstname ,lastname ,email ,age ,state ,course);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }
    public List<User> selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname=   rs.getString("lastname");
                Integer age =      rs.getInt("age");
                String email=      rs.getString("email");
                String state=      rs.getString("state");
                String course=     rs.getString("course");
                users.add(new User(id,firstname ,lastname ,email ,age ,state ,course));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getLastname());
            statement.setString(3, user.getEmail());
            statement.setInt(4,user.getAge());
            statement.setString(5, user.getState());
            statement.setString(6, user.getCourse());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}










































