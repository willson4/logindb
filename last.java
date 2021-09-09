//package com.seek;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
// import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class last {
//    private String jdbcURL = "jdbc:mysql://localhost:3306/save?useSSL=false";
//    private String jdbcUsername = "root";
//    private String jdbcPassword = "R&oot567";
//
//    private static final String INSERT_USERS_SQL = "INSERT INTO students" + "  (firstname,lastname,email,age,state,country) VALUES "
//            + " (?, ?, ?, ?, ?, ?);";
//
//    private static final String SELECT_USER_BY_ID = "select id,firstname,lastname,email,age,state,country from student where id =?";
//    private static final String SELECT_ALL_USERS = "select * from users";
//    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
//    private static final String UPDATE_USERS_SQL = "update users set firstname = ?,lastname = ?, email= ?, age = ?, state = ?, country =? where id = ?;";
//
//    public last() {
//    }
//
//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//        } catch (SQLException e) {
//            //TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    public void insertLast(String email, String firstName) throws SQLException {
//        System.out.println(INSERT_USERS_SQL);
//        // try-with-resource statement will auto close the connection.
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//            preparedStatement.setString(1, email);
//            preparedStatement.setString(1, last.getLastname());
//            preparedStatement.setString(1, last.getAge());
////            preparedStatement.setString(2, last.getEmail());
//            preparedStatement.setString(1, last.getState());
//            preparedStatement.setString(3, last.getCountry());
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//    }
//
//    private String getFirstname() {
//    }
//
//    public last selectLast(int id) {
//        last last = null;
//        // Step 1: Establishing a Connection
//        try (Connection connection = getConnection();
//             // Step 2:Create Ua statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
//            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
////                user = new User(id, name, email, country);
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return user;
//    }
//
//
//
//}