package src.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbServices {


    
    private static Connection connection = null;

    private static final String URL = "jdbc:mysql://localhost:3306/qtella_api";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // private static final String URL = System.getenv("DB_URL");
    // private static final String USERNAME = System.getenv("DB_USERNAME");
    // private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet executeQuery(String query) {
        Connection connection = getConnection();
        ResultSet resultSet = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

 public static int runExecuteUpdate(String query) {
        Connection connection = getConnection();
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }
}
