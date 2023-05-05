import org.junit.Test;
import root.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    @Test
    public void connectionTest() throws SQLException {
        Connection connection = DbConnector.connect();
    }

    @Test
    public void queryTest() throws SQLException {

        try {
            ResultSet result = QueryExecutor.executeSelect("SELECT * FROM words WHERE id = 666");
            String wordName = result.getString("eng_word");
            System.out.println(wordName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
