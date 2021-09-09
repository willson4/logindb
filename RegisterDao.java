package org.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    public String registerUser(RegisterBean registerBean) {
        String fullName = registerBean.getMatno();
        String password = registerBean.getPassword();

        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.createConnection();
            String query = "insert into registers(id,matno,password) values (NULL,?,?)";
            preparedStatement = con.prepareStatement(query);
            String matno = null;
            preparedStatement.setString(1, matno);
            preparedStatement.setString(2, password);

            int i = preparedStatement.executeUpdate();

            if (i != 0)
                return "SUCCESS";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Oops.. Something went wrong there..!";
    }
}
