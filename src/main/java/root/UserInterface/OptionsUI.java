package root.UserInterface;

import root.Mechanics;
import root.Utilities;

import javax.swing.*;

public class OptionsUI extends SetupUI{

    UI ui;

    public JPanel menuPanel, totalPanel;
    public JLabel dbHeaderLabel, wordsQtyHeaderLabel, seenWordsLabel, passedWordsLabel, consolidatedWordsLabel,
            masteredWordsLabel, problematicWordsLabel;
    JLabel dbsLabel;
    JButton returnButton;
    JButton firstSetBtn, secondSetBtn, thirdSetBtn, fourthSetBtn, fifthSetBtn, sixthSetBtn, seventhSetBtn,
            eighthSetBtn, ninthSetBtn, tenthSetBtn, eleventhSetBtn, twelfthSetBtn, thirteenthSetBtn, fourteenthSetBtn,
            fifteenSetBtn, sixteenSetBtn, seventeenSetBtn, eighteenthSetBtn, nineteenSetBtn, twentiethSetBtn;

    JButton[] setBtns = {firstSetBtn, secondSetBtn, thirdSetBtn, fourthSetBtn, fifthSetBtn, sixthSetBtn, seventhSetBtn,
            eighthSetBtn, ninthSetBtn, tenthSetBtn, eleventhSetBtn, twelfthSetBtn, thirteenthSetBtn, fourteenthSetBtn,
            fifteenSetBtn, sixteenSetBtn, seventeenSetBtn, eighteenthSetBtn, nineteenSetBtn, twentiethSetBtn};

    public OptionsUI(UI ui) {
        this.ui = ui;
    }

    public void menuPanelsSetup() {
        menuPanel = UtilsUI.makePanel(margin, margin, 300, windowY - margin * 2, mediumGray);
        ui.con.add(menuPanel);

        dbsLabel = UtilsUI.makeLabel("Databases:", headerFont, JLabel.LEFT);
        dbsLabel.setBounds(margin, labelMargin, 150, headerFont.getSize());
        menuPanel.add(dbsLabel);

        dbTotalButton = UtilsUI.makeButton("Total", buttonFont, dbsLabel.getX(),
                dbsLabel.getY() + dbsLabel.getHeight() + margin, menuPanel.getWidth() - 2 * margin,
                40, mediumPurple);
        dbTotalButton.addActionListener(ui.ah.navigateHandler);
        dbTotalButton.setActionCommand("total");
        menuPanel.add(dbTotalButton);

        dbThemesButton = UtilsUI.makeButton("Themes", buttonFont, dbsLabel.getX(),
                dbTotalButton.getY() + dbTotalButton.getHeight() + margin/2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbThemesButton.addActionListener(ui.ah.navigateHandler);
        dbThemesButton.setActionCommand("themes");
        menuPanel.add(dbThemesButton);

        dbRepetitionButton = UtilsUI.makeButton("Repetition", buttonFont, dbsLabel.getX(),
                dbThemesButton.getY() + dbThemesButton.getHeight() + margin/2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbRepetitionButton.addActionListener(ui.ah.navigateHandler);
        dbRepetitionButton.setActionCommand("repetition");
        menuPanel.add(dbRepetitionButton);

        dbMarkedButton = UtilsUI.makeButton("Marked", buttonFont, dbsLabel.getX(),
                dbRepetitionButton.getY() + dbTotalButton.getHeight() + margin/2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbMarkedButton.addActionListener(ui.ah.navigateHandler);
        dbMarkedButton.setActionCommand("marked");
        menuPanel.add(dbMarkedButton);

        dbSearchEngineButton = UtilsUI.makeButton("Search Engine", buttonFont, dbsLabel.getX(),
                dbMarkedButton.getY() + dbTotalButton.getHeight() + margin/2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbSearchEngineButton.addActionListener(ui.ah.navigateHandler);
        dbSearchEngineButton.setActionCommand("search engine");
        menuPanel.add(dbSearchEngineButton);
    }

    public void totalPanelSetup() {

        Mechanics.totalWordsQty = Mechanics.totalSetRecordsQty(); //here
        System.out.println(Mechanics.totalWordsQty);

        totalPanel = UtilsUI.makePanel(menuPanel.getX(), menuPanel.getY(), menuPanel.getWidth(), menuPanel.getHeight(),
                mediumGray);
        ui.con.add(totalPanel);
        totalPanel.setVisible(false);

        returnButton = UtilsUI.makeButton("Return", buttonFont, totalPanel.getX(), totalPanel.getY() +
                totalPanel.getHeight() - margin - 50, totalPanel.getWidth() - 2 * margin, 50, mediumPurple);
        returnButton.addActionListener(ui.ah.navigateHandler);
        returnButton.setActionCommand("return");
        totalPanel.add(returnButton);

        dbHeaderLabel = UtilsUI.makeLabel("Database: Total", headerFont, JLabel.LEFT);
        dbHeaderLabel.setBounds(dbsLabel.getX(), dbsLabel.getY(), returnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(dbHeaderLabel);

        wordsQtyHeaderLabel = UtilsUI.makeLabel("Words quantity: " + Mechanics.totalWordsQty, normalFont, JLabel.LEFT);
        wordsQtyHeaderLabel.setBounds(dbsLabel.getX(), dbsLabel.getY() + dbsLabel.getHeight(),
                returnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(wordsQtyHeaderLabel);

        seenWordsLabel = UtilsUI.makeLabel("Seen: ", normalFont, JLabel.LEFT);
        seenWordsLabel.setBounds(dbsLabel.getX(), wordsQtyHeaderLabel.getY() + wordsQtyHeaderLabel.getHeight(),
                returnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(seenWordsLabel);

        passedWordsLabel = UtilsUI.makeLabel("Passed: ", normalFont, JLabel.LEFT);
        passedWordsLabel.setBounds(dbsLabel.getX(), seenWordsLabel.getY() + wordsQtyHeaderLabel.getHeight(),
                returnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(passedWordsLabel);

        consolidatedWordsLabel = UtilsUI.makeLabel("Consolidated: ", normalFont, JLabel.LEFT);
        consolidatedWordsLabel.setBounds(dbsLabel.getX(), passedWordsLabel.getY() + wordsQtyHeaderLabel.getHeight(),
                returnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(consolidatedWordsLabel);

        masteredWordsLabel = UtilsUI.makeLabel("Mastered: ", normalFont, JLabel.LEFT);
        masteredWordsLabel.setBounds(dbsLabel.getX(), consolidatedWordsLabel.getY() + wordsQtyHeaderLabel.getHeight(),
                returnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(masteredWordsLabel);

        problematicWordsLabel = UtilsUI.makeLabel("Problematic: ", normalFont, JLabel.LEFT);
        problematicWordsLabel.setBounds(dbsLabel.getX(), masteredWordsLabel.getY() + wordsQtyHeaderLabel.getHeight(),
                returnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(problematicWordsLabel);

//        -----------------------------------Buttons-----------------------------------------
        int i = 1;
        int y = 0;
        for (JButton button: setBtns) {
            button = UtilsUI.makeButton(Utilities.integerToRomanNumber(i), headerFont, dbsLabel.getX(), problematicWordsLabel.getY() + y +
                    wordsQtyHeaderLabel.getHeight(), returnButton.getWidth(), 30, mediumPurple);
            button.addActionListener(ui.ah.navigateHandler);
            button.setActionCommand("total " + i);
            totalPanel.add(button);
            y += 30;
            i += 1;
        }
    }
}
