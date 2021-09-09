package com.seek;

//import jdk.internal.icu.impl.CharacterIteratorWrapper;

//import java.sql.*;
//
//
//public class DatabaseConnection {
//    private static Connection connect = null;
//    private static CharacterIteratorWrapper results;
//    private Statement statement = null;
//    private PreparedStatement preparedStatement = null;
//    private ResultSet resultSet = null;


      //  public static void insertToStudentsTable () throws SQLException {
       //     try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dictionary_db?user=root&password=a");
            //     PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
               //  ResultSet results = statement.executeQuery();) {

//                while (results.next()) {
//                    int id = results.getInt(1);
//                    String fristname = results.getString("fristname");
//                    String lastname= results.getString("lastname");
//                    String email = results.getString("email");
//                    int age = results.getInt("age");
//                    String state= results.getString("state");
//                    String course = results.getString("course");
//                    System.out.println("Id: " + id + ", fristname :"  + fristname + ", lastname: " + lastname +", email: "+ email +", age:"+ age +", state:" + state +", course:"+ course);
//                }
//
//            } catch (SQLException ex) {
//                System.out.println("Error while communicating with the database");
//            }
//
//    }
//}
