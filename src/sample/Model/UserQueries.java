package sample.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserQueries extends DatabaseConnection {

    public Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    public UserQueries() {
        try {
            this.connection = getConnection();
            this.statement = connection.createStatement();

        } catch (SQLException sq) {
            System.out.println(sq.getMessage());
        }
    }

    public User getUser(String userIn, String pwIn) {
        System.out.println("Entered verify login.");
        User user = new User();
        try {
            String sql = "SELECT * FROM user WHERE username = '" + userIn + "';";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                if (resultSet.getString("password").equals(pwIn)){
                    System.out.println("login");
                    user.setName(resultSet.getString("username"));
                    user.setAccountNumber(resultSet.getInt("account_number"));
                }
            }
            // disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public Account getAccount(int accNumber) {
        Account acc = null;
        try {
            String sql = "SELECT * FROM account WHERE account_number = '" + accNumber + "';";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                    double balance = resultSet.getDouble("balance");
                    acc = new Account(accNumber, balance);
            }
            // disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }

    public boolean setBalance(Account acc){
        try {
            String sql = "UPDATE account SET balance = "+acc.getAccountBalance()+" WHERE account_number = "+acc.getAccountNumber()+";";
            statement = connection.createStatement();
            return statement.execute(sql);
            // disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}