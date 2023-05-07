import org.junit.Test;
import root.Mechanics;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MechanicsTests {

    @Test
    public void randomWord_Test() {
        String word = Mechanics.randomWord("words", "eng_word", 999);
        System.out.println("Rolled word is: " + word);
    }

    @Test
    public void randomWordResultSet_Test() throws SQLException {
        ResultSet result = Mechanics.randomWordResultSet("words", 999);
        assert result != null;
        System.out.println("Rolled word: " + result.getString("eng_word") + "\n" +
                "Meaning: " + result.getString("pol_word") + "\n" +
                "Id: " + result.getString("id") + "\n" +
                "Part of Speech: " + result.getString("part_of_speech"));
    }

}
