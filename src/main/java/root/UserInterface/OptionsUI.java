package root.UserInterface;

import root.Mechanics;
import root.Utilities;

import javax.swing.*;

public class OptionsUI extends SetupUI{

    UI ui;

    public JPanel menuPanel, totalPanel, themesPanel;
    public JLabel totDbHeaderLabel, totWordsQtyHeaderLabel, totSeenWordsLabel, totPassedWordsLabel, totConsolidatedWordsLabel,
            totMasteredWordsLabel, totProblematicWordsLabel;
    JLabel dbsLabel;
    JButton totReturnButton, themesReturnButton;
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

        Mechanics.totalWordsQty = Mechanics.totalSetRecordsQty();

        totalPanel = UtilsUI.makePanel(menuPanel.getX(), menuPanel.getY(), menuPanel.getWidth(), menuPanel.getHeight(),
                mediumGray);
        ui.con.add(totalPanel);
        totalPanel.setVisible(false);

        totReturnButton = UtilsUI.makeButton("Return", buttonFont, totalPanel.getX(), totalPanel.getY() +
                totalPanel.getHeight() - 2*margin - 50, totalPanel.getWidth() - 2 * margin, 50, mediumPurple);
        totReturnButton.addActionListener(ui.ah.navigateHandler);
        totReturnButton.setActionCommand("totReturn");
        totalPanel.add(totReturnButton);

        totDbHeaderLabel = UtilsUI.makeLabel("Database: Total", headerFont, JLabel.LEFT);
        totDbHeaderLabel.setBounds(dbsLabel.getX(), dbsLabel.getY(), totReturnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(totDbHeaderLabel);

        totWordsQtyHeaderLabel = UtilsUI.makeLabel("Words quantity: " + Mechanics.totalWordsQty, normalFont, JLabel.LEFT);
        totWordsQtyHeaderLabel.setBounds(dbsLabel.getX(), dbsLabel.getY() + dbsLabel.getHeight(),
                totReturnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(totWordsQtyHeaderLabel);

        totSeenWordsLabel = UtilsUI.makeLabel("Seen: ", normalFont, JLabel.LEFT);
        totSeenWordsLabel.setBounds(dbsLabel.getX(), totWordsQtyHeaderLabel.getY() + totWordsQtyHeaderLabel.getHeight(),
                totReturnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(totSeenWordsLabel);

        totPassedWordsLabel = UtilsUI.makeLabel("Passed: ", normalFont, JLabel.LEFT);
        totPassedWordsLabel.setBounds(dbsLabel.getX(), totSeenWordsLabel.getY() + totWordsQtyHeaderLabel.getHeight(),
                totReturnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(totPassedWordsLabel);

        totConsolidatedWordsLabel = UtilsUI.makeLabel("Consolidated: ", normalFont, JLabel.LEFT);
        totConsolidatedWordsLabel.setBounds(dbsLabel.getX(), totPassedWordsLabel.getY() + totWordsQtyHeaderLabel.getHeight(),
                totReturnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(totConsolidatedWordsLabel);

        totMasteredWordsLabel = UtilsUI.makeLabel("Mastered: ", normalFont, JLabel.LEFT);
        totMasteredWordsLabel.setBounds(dbsLabel.getX(), totConsolidatedWordsLabel.getY() + totWordsQtyHeaderLabel.getHeight(),
                totReturnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(totMasteredWordsLabel);

        totProblematicWordsLabel = UtilsUI.makeLabel("Problematic: ", normalFont, JLabel.LEFT);
        totProblematicWordsLabel.setBounds(dbsLabel.getX(), totMasteredWordsLabel.getY() + totWordsQtyHeaderLabel.getHeight(),
                totReturnButton.getWidth(), dbsLabel.getHeight());
        totalPanel.add(totProblematicWordsLabel);

//        -----------------------------------Buttons-----------------------------------------
        int i = 1;
        int y = 0;
        for (JButton button: setBtns) {
            button = UtilsUI.makeButton(Utilities.integerToRomanNumber(i), headerFont, dbsLabel.getX(), totProblematicWordsLabel.getY() + y +
                    totWordsQtyHeaderLabel.getHeight(), totReturnButton.getWidth(), 30, mediumPurple);
            button.addActionListener(ui.ah.navigateHandler);
            button.setActionCommand("total " + i);
            totalPanel.add(button);
            y += 30;
            i += 1;
        }
    }

    public void themesPanelSetup(){

        themesPanel = UtilsUI.makePanel(totalPanel.getX(), totalPanel.getY(), totalPanel.getWidth(),
                totalPanel.getHeight(), mediumGray);
        ui.con.add(themesPanel);
        themesPanel.setVisible(false);

        themesReturnButton = UtilsUI.makeButton("Return", buttonFont, totalPanel.getX(), totalPanel.getY() +
                totalPanel.getHeight() - 2*margin - 50, totalPanel.getWidth() - 2 * margin, 50, mediumPurple);
        themesReturnButton.addActionListener(ui.ah.navigateHandler);
        themesReturnButton.setActionCommand("themesReturn");
        themesPanel.add(themesReturnButton);
    }
}
