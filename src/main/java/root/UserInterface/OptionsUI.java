package root.UserInterface;

import root.Mechanics;
import root.Utilities;

import javax.swing.*;

public class OptionsUI extends SetupUI {

    UI ui;

    public JPanel menuPanel, totalPanel, themesPanel, markedPanel, repetitionPanel, searchEnginePanel;
    public JLabel totDbHeaderLabel, totWordsQtyHeaderLabel, totSeenWordsLabel, totPassedWordsLabel, totConsolidatedWordsLabel,
            totMasteredWordsLabel, totProblematicWordsLabel;
    JLabel dbsLabel, themesDbHeaderLabel;
    JButton totReturnButton, themesReturnButton, repetitionReturnButton, markedReturnButton, searchEngineReturnButton;
    JButton dailySetButton, it_csSetButton, engineeringSetButton;
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
                dbTotalButton.getY() + dbTotalButton.getHeight() + margin / 2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbThemesButton.addActionListener(ui.ah.navigateHandler);
        dbThemesButton.setActionCommand("themes");
        menuPanel.add(dbThemesButton);

        dbRepetitionButton = UtilsUI.makeButton("Repetition", buttonFont, dbsLabel.getX(),
                dbThemesButton.getY() + dbThemesButton.getHeight() + margin / 2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbRepetitionButton.addActionListener(ui.ah.navigateHandler);
        dbRepetitionButton.setActionCommand("repetition");
        menuPanel.add(dbRepetitionButton);

        dbMarkedButton = UtilsUI.makeButton("Marked", buttonFont, dbsLabel.getX(),
                dbRepetitionButton.getY() + dbTotalButton.getHeight() + margin / 2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbMarkedButton.addActionListener(ui.ah.navigateHandler);
        dbMarkedButton.setActionCommand("marked");
        menuPanel.add(dbMarkedButton);

        dbSearchEngineButton = UtilsUI.makeButton("Search Engine", buttonFont, dbsLabel.getX(),
                dbMarkedButton.getY() + dbTotalButton.getHeight() + margin / 2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbSearchEngineButton.addActionListener(ui.ah.navigateHandler);
        dbSearchEngineButton.setActionCommand("searchEngine");
        menuPanel.add(dbSearchEngineButton);

        totalPanelSetup();
        themesPanelSetup();
        markedPanelSetup();
        repetitionPanelSetup();
        searchEngineSetup();
    }

    public void totalPanelSetup() {

        Mechanics.totalWordsQty = Mechanics.totalSetRecordsQty();

        totalPanel = UtilsUI.makePanel(menuPanel.getX(), menuPanel.getY(), menuPanel.getWidth(), menuPanel.getHeight(),
                mediumGray);
        ui.con.add(totalPanel);
        totalPanel.setVisible(false);

        totReturnButton = UtilsUI.makeButton("Return", buttonFont, totalPanel.getX(), totalPanel.getY() +
                totalPanel.getHeight() - 2 * margin - 50, totalPanel.getWidth() - 2 * margin, 50, mediumPurple);
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
        for (JButton button : setBtns) {
            button = UtilsUI.makeButton(Utilities.integerToRomanNumber(i), headerFont, dbsLabel.getX(), totProblematicWordsLabel.getY() + y +
                    totWordsQtyHeaderLabel.getHeight(), totReturnButton.getWidth(), 30, mediumPurple);
            button.addActionListener(ui.ah.navigateHandler);
            button.setActionCommand("total " + i);
            totalPanel.add(button);
            y += 30;
            i += 1;
        }
    }

    public void themesPanelSetup() {

        themesPanel = UtilsUI.makePanel(totalPanel.getX(), totalPanel.getY(), totalPanel.getWidth(),
                totalPanel.getHeight(), mediumGray);
        ui.con.add(themesPanel);
        themesPanel.setVisible(false);

        themesReturnButton = UtilsUI.makeButton("Return", buttonFont, totalPanel.getX(), totalPanel.getY() +
                totalPanel.getHeight() - 2 * margin - 50, totalPanel.getWidth() - 2 * margin, 50, mediumPurple);
        themesReturnButton.addActionListener(ui.ah.navigateHandler);
        themesReturnButton.setActionCommand("themesReturn");
        themesPanel.add(themesReturnButton);

        themesDbHeaderLabel = UtilsUI.makeLabel("Database: Themes", headerFont, JLabel.LEFT);
        themesDbHeaderLabel.setBounds(dbsLabel.getX(), dbsLabel.getY(), totReturnButton.getWidth(), dbsLabel.getHeight());
        themesPanel.add(themesDbHeaderLabel);

        dailySetButton = UtilsUI.makeButton("Daily", buttonFont, dbsLabel.getX(), dbTotalButton.getY(),
                themesReturnButton.getWidth(), 50, mediumPurple);
        dailySetButton.addActionListener(ui.ah.navigateHandler);
        dailySetButton.setActionCommand("dailySet");
        themesPanel.add(dailySetButton);

        it_csSetButton = UtilsUI.makeButton("IT & CS", buttonFont, dbsLabel.getX(),
                dailySetButton.getY() + dailySetButton.getHeight() + margin/2,
                themesReturnButton.getWidth(), 50, mediumPurple);
        it_csSetButton.addActionListener(ui.ah.navigateHandler);
        it_csSetButton.setActionCommand("it_cs");
        themesPanel.add(it_csSetButton);

        engineeringSetButton = UtilsUI.makeButton("Engineering", buttonFont, dbsLabel.getX(),
                it_csSetButton.getY() + it_csSetButton.getHeight() + margin/2,
                themesReturnButton.getWidth(), 50, mediumPurple);
        engineeringSetButton.addActionListener(ui.ah.navigateHandler);
        engineeringSetButton.setActionCommand("engineering");
        themesPanel.add(engineeringSetButton);
    }

    public void markedPanelSetup() {

        markedPanel = UtilsUI.makePanel(totalPanel.getX(), totalPanel.getY(), totalPanel.getWidth(),
                totalPanel.getHeight(), mediumGray);
        ui.con.add(markedPanel);
        markedPanel.setVisible(false);

        markedReturnButton = UtilsUI.makeButton("Return", buttonFont, totalPanel.getX(), totalPanel.getY() +
                totalPanel.getHeight() - 2 * margin - 50, totalPanel.getWidth() - 2 * margin, 50, mediumPurple);
        markedReturnButton.addActionListener(ui.ah.navigateHandler);
        markedReturnButton.setActionCommand("markedReturn");
        markedPanel.add(markedReturnButton);

    }

    public void repetitionPanelSetup() {

        repetitionPanel = UtilsUI.makePanel(totalPanel.getX(), totalPanel.getY(), totalPanel.getWidth(),
                totalPanel.getHeight(), mediumGray);
        ui.con.add(repetitionPanel);
        repetitionPanel.setVisible(false);

        repetitionReturnButton = UtilsUI.makeButton("Return", buttonFont, totalPanel.getX(), totalPanel.getY() +
                totalPanel.getHeight() - 2 * margin - 50, totalPanel.getWidth() - 2 * margin, 50, mediumPurple);
        repetitionReturnButton.addActionListener(ui.ah.navigateHandler);
        repetitionReturnButton.setActionCommand("repetitionReturn");
        repetitionPanel.add(repetitionReturnButton);

    }

    public void searchEngineSetup() {

        searchEnginePanel = UtilsUI.makePanel(totalPanel.getX(), totalPanel.getY(), totalPanel.getWidth(),
                totalPanel.getHeight(), mediumGray);
        ui.con.add(searchEnginePanel);
        searchEnginePanel.setVisible(false);

        searchEngineReturnButton = UtilsUI.makeButton("Return", buttonFont, totalPanel.getX(), totalPanel.getY() +
                totalPanel.getHeight() - 2 * margin - 50, totalPanel.getWidth() - 2 * margin, 50, mediumPurple);
        searchEngineReturnButton.addActionListener(ui.ah.navigateHandler);
        searchEngineReturnButton.setActionCommand("searchEngineReturn");
        searchEnginePanel.add(searchEngineReturnButton);

    }
}