import org.junit.Test;
import root.DbConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    @Test
    public static void main(String[] args) throws SQLException {
        Connection connection = DbConnector.connect();
    }
}
