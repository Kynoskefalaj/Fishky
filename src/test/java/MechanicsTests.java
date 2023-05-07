import org.junit.Test;
import root.Mechanics;

public class MechanicsTests {

    @Test
    public void randomWordTest() {
        String word = Mechanics.randomWord("words", "eng_word", 999);
        System.out.println("Rolled word is: " + word);
    }
}
