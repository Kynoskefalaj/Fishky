package root;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class QueryExecutor {

    public static ResultSet executeSelect(String selectQuery) {
        try {
            Connection connection = DbConnector.connect();
            Statement statement = connection.createStatement();
            return statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void executeQuery(String query) {
        try {
            Connection connection = DbConnector.connect();
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void executeQueries_oneByOne (List<String> queries) {
        // Notation "::" means that the method "executeQuery" is executed for each element in list "queries"
        queries.forEach(QueryExecutor::executeQuery);
    }

    public static void executeQuery(String query, Connection connection) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e){
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new RuntimeException("ROLLBACK");
        }
    }

    public static void executeQueries_oneTransaction (List<String> queries) throws SQLException {
        Connection connection = DbConnector.connect();
        connection.setAutoCommit(false);
        queries.forEach(query -> executeQuery(query, connection));
        connection.commit();
        connection.close();
    }

}
