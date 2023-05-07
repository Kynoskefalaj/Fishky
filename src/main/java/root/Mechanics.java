package root;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Mechanics {

    UI ui;

    public Mechanics (UI ui) {
        this.ui = ui;
    }

    public static String randomWord (String tableName, String column, int rollRange) {
        Random random = new Random();
        int randInt = random.nextInt(rollRange);

        String sqlRequest = "SELECT * FROM " + tableName + " WHERE id = " + randInt;
        try {
            ResultSet result = QueryExecutor.executeSelect(sqlRequest);
            result.next();
            return result.getString(column);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet randomWordResultSet (String tableName, int rollRange) {
        Random random = new Random();
        int randInt = random.nextInt(rollRange);

        String sqlRequest = "SELECT * FROM " + tableName + " WHERE id = " + randInt;
        try {
            ResultSet result = QueryExecutor.executeSelect(sqlRequest);
            result.next();
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}

