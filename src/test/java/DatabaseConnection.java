import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import root.DbConnector;
import root.QueryExecutor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DatabaseConnection {

    @BeforeAll
    public void connectionTest() throws SQLException {
        try {
            Connection connection = DbConnector.connect();
            System.out.println("Connected successfully, test passed.");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Test
    public void selectTest() {

        try {
            ResultSet result = QueryExecutor.executeSelect("SELECT * FROM words WHERE id = 666");
            result.next();
            String wordName = result.getString("eng_word");
            System.out.println(wordName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest() {
        QueryExecutor.executeQuery("INSERT INTO fishky.users (id, email, passwd, nickname) " +
                    "VALUES (1, \"john_doe@gmail.com\", \"1234\", \"Johny\");");
        System.out.println("Test passed, user added.");
    }

    @Test
    public void deleteTest() {
        QueryExecutor.executeQuery("DELETE FROM users");
        QueryExecutor.executeQuery("ALTER TABLE users AUTO_INCREMENT = 1");
        System.out.println("Test passed, user deleted. \n Auto_increment reset.");
    }

    @Test
    public void addUsersTest() {
        String query1 = "INSERT INTO users " +
                "(email, passwd, nickname) VALUES (\"johndoe@gmail.com\", \"1234\", \"Johny\");";
        String query2 = "INSERT INTO users " +
                "(email, passwd, nickname) VALUES (\"mikelkase@gmail.com\", \"qwerty\", \"Mikel\");";

        List<String> queries = Arrays.asList(query1, query2);
        QueryExecutor.executeQueries_oneByOne(queries);
    }

    @Test
    public void queries_oneByOne_test() {
        String query1 = "UPDATE users " +
                "SET permission_level = 0 WHERE id = 1";
        //second query is intentionally wrong (id = 22 don't exist)
        String query2 = "UPDATE users " +
                "SET permission_level = 3 WHERE id =/ 22";

        List<String> queries = Arrays.asList(query1, query2);
        QueryExecutor.executeQueries_oneByOne(queries);
        //as result first query should be executed and second don't
    }

    @Test
    public void queriesInOneTransaction_test() throws SQLException {
        String query1 = "UPDATE users " +
                "SET permission_level = 1 WHERE id = 1";
        //second query is intentionally wrong (id = 22 don't exist)
        String query2 = "UPDATE users " +
                "SET permission_level = 3 WHERE id =/ 22";

        List<String> queries = Arrays.asList(query1, query2);
        QueryExecutor.executeQueries_oneTransaction(queries);
        //as result no one query should be installed

    }

}
