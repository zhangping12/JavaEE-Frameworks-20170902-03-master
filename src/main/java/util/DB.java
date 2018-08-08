package util;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class DB {

    private static final String URL = "jdbc:mysql:///?user=root&password=system";

    public static Connection getConnection() {
        try {
            new Driver();
            Connection connection = DriverManager.getConnection(URL);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
