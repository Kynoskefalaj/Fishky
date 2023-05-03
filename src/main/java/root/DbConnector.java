package root;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/fishky";
    private static final String USER = "root";
    private static final String PASSWORD = "baster1994";


    public static Connection connect() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Connection error.");
            e.printStackTrace();
        }
        return connection;
    }
}
