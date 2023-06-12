package root.UserInterface;

import root.Mechanics;

import javax.swing.*;
import java.awt.*;

public class SetupUI {

    Container con;
    protected Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    protected Font headerFont = new Font("Times New Roman", Font.BOLD, 30);
    protected Font wordFont = new Font("Arial", Font.BOLD, 45);
    protected Font textFont = new Font("Times New Roman", Font.PLAIN, 19);
    protected Font buttonFont = new Font("Arial", Font.BOLD, 25);
    protected Font smallHeaderFont = new Font("Times New Roman", Font.PLAIN, 25);
    protected Font notificationFont = new Font("Arial", Font.BOLD, 20);

    protected Color veryDarkGray = new Color(15, 15, 15);
    protected Color darkGray = new Color(30, 30, 30);
    protected static Color mediumGray = new Color (40, 40, 40);
    protected Color lightGray = new Color (50, 50, 50);
    protected Color veryLightGray = new Color (60, 60, 60);
    protected Color mediumPurple = new Color (70, 70, 206);
    public Color goodColor = new Color(48, 206, 59);
    public Color badColor = new Color(187, 66, 66);

    JButton dbTotalButton, dbThemesButton, dbRepetitionButton, dbMarkedButton, dbSearchEngineButton;
    JButton heartButton, starButton, helpButton, exclamationButton;
    protected ImageIcon heartIcon, starIcon, helpIcon, exclamationIcon;
    public JButton enterButton, nextButton, checkButton, hintButton, okButton, nokButton, submitButton;

    protected final int windowX = 1600;
    protected final int windowY = 900;

    protected final int margin = 8;
    protected final int labelMargin = 5;

    public int wordsQty = Mechanics.totalSetRecordsQty();

}
