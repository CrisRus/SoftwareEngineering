package sample.Model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class DatabaseConnection {

    static  java.sql.Connection connection=null;
    static  Statement statement=null;
    ResultSet resultSet=null;

    String url="jdbc:mysql://localhost:3306/lab2?user=root&password= root";


    protected DatabaseConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url);
            statement = connection.createStatement();
            System.out.println("Connected");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public java.sql.Connection getConnection() {

        return connection;
    }
    // disconnect from database
    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }


}
