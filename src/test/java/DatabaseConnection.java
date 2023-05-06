import org.junit.Test;
import root.DbConnector;
import root.QueryExecutor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    @Test
    public void connectionTest() throws SQLException {
        Connection connection = DbConnector.connect();
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
        QueryExecutor.executeQuery("DELETE FROM users WHERE id = 1");
        System.out.println("Test passed, user deleted.");
    }

}
