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

    @Test
    public void getFrequencyFields_test() throws SQLException {

        ResultSet wordResult = Mechanics.randomWordResultSet("words", 999);
        assert wordResult != null;

        ResultSet frequencyResult = Mechanics.getFrequencyFields(wordResult);
        assert frequencyResult != null;

        System.out.println("Rolled word: " + wordResult.getString("eng_word") + "\n" +
                "Meaning: " + wordResult.getString("pol_word") + "\n" +
                "Id: " + wordResult.getString("id") + "\n" +
                "Part of Speech: " + wordResult.getString("part_of_speech") + "\n" +
                "word_id: " + frequencyResult.getString("word_id") + "\n" +
                "ranking_position: " + frequencyResult.getString("ranking_position") + "\n" +
                "frequency_daily: " + frequencyResult.getString("frequency_daily") + "\n" +
                "frequency_IT: " + frequencyResult.getString("frequency_IT"));
    }

    @Test
    public void getExplanationFields_test() throws SQLException {

        ResultSet wordResult = Mechanics.randomWordResultSet("words", 999);
        assert wordResult != null;

        ResultSet explanationResult = Mechanics.getExplanationFields(wordResult);
        assert explanationResult != null;

        System.out.println("Rolled word: " + wordResult.getString("eng_word") + "\n" +
                "Meaning: " + wordResult.getString("pol_word") + "\n" +
                "Id: " + wordResult.getString("id") + "\n" +
                "Part of Speech: " + wordResult.getString("part_of_speech") + "\n" +
                "word_id: " + explanationResult.getString("word_id") + "\n" +
                "eng_phrase: " + explanationResult.getString("eng_phrase") + "\n" +
                "pol_phrase: " + explanationResult.getString("pol_phrase") + "\n" +
                "eng_sentence: " + explanationResult.getString("eng_sentence") + "\n" +
                "eng_explanation: " + explanationResult.getString("eng_explanation"));
    }
}
