package root;

import javax.swing.*;
import java.awt.*;

public class UI {

    JFrame window;
    Container con;

    JPanel optionsPanel, mainPanel, wordPanel, userPanel;
    JPanel dataBasePanel, mainWordPanel, grammarPanel, commentPanel, examplePanel, tagsPanel, picturePanel,
            userActionPanel;
    JLabel dbsLabel, feedbackLabel, wordLabel, commentLabel, exampleLabel, tagsLabel, posLabel, posValueLabel,
            currentDB_Label, currDB_ValueLabel, hintLabel, isSubmittedLabel;

    int windowX = 1600;
    int windowY = 900;

    int margin = 8;
    int labelMargin = 5;

    int optionsPanelWidth, mainPanelWidth, wordPanelWidth, userPanelWidth, mainWordPanelWidth, dataBasePanelWidth,
        commentPanelWidth, commentPanelLevel, wordPanelHeight, userPanelHeight, dataBasePanelHeight,
        mainWordPanelHeight, commentPanelHeight;

    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font headerFont = new Font("Times New Roman", Font.BOLD, 30);
    Font wordFont = new Font("Arial", Font.BOLD, 45);

    Color darkGray = new Color(30, 30, 30);
    Color mediumGray = new Color (40, 40, 40);
    Color lightGray = new Color (50, 50, 50);
    Color veryLightGray = new Color (60, 60, 60);
    Color mediumPurple = new Color (70, 70, 206);

    public UI() {
        displayWindow();
        displayScreen();
//        Thread.sleep(4000);
    }

    void displayWindow() {
        window = new JFrame();
        window.setSize(windowX + 13, windowY + 36);
        window.getContentPane().setBackground(darkGray);
        window.setVisible(true);
        window.setLayout(null);

        con = window.getContentPane();
    }

    void displayScreen() {
        optionsPanelWidth = 300;
        optionsPanel = makePanel(margin, margin, optionsPanelWidth, windowY - margin * 2, mediumGray);
        optionsPanel.setLayout(new GridLayout(13, 1));
        con.add(optionsPanel);

        mainPanelWidth = windowX - optionsPanelWidth - margin * 3;
        mainPanel = makePanel(margin * 2 + optionsPanelWidth, margin, mainPanelWidth,
                windowY - margin * 2, mediumGray);
        mainPanel.setLayout(null); //set panel's layout to null to have control on its child's boundaries
        con.add(mainPanel);
//        mainPanel.setVisible(false);

        wordPanelWidth = mainPanelWidth - margin * 2;
        wordPanelHeight = 500;
        wordPanel = makePanel(margin, margin, wordPanelWidth, wordPanelHeight, lightGray);
        wordPanel.setLayout(null);
        mainPanel.add(wordPanel);

        userPanelWidth = wordPanelWidth;
        userPanelHeight = windowY - wordPanelHeight - margin * 5;
        userPanel = makePanel(margin,wordPanelHeight + margin * 2,
                userPanelWidth, userPanelHeight, lightGray);
        userPanel.setLayout(null);
        mainPanel.add(userPanel);

        mainWordPanelWidth = 500;
        mainWordPanelHeight = 150;
        mainWordPanel = makePanel(mainPanelWidth/2 - mainWordPanelWidth/2 - margin, margin,
                mainWordPanelWidth, mainWordPanelHeight, veryLightGray);
        wordPanel.add(mainWordPanel);
        mainWordPanel.setLayout(new GridLayout(2, 1));


        dataBasePanelWidth = (wordPanelWidth - margin * 4 - mainWordPanelWidth) / 2;
        dataBasePanelHeight = mainWordPanelHeight;
        dataBasePanel = makePanel(margin, margin, dataBasePanelWidth, dataBasePanelHeight, veryLightGray);
        wordPanel.add(dataBasePanel);

        grammarPanel = makePanel(margin * 3 + dataBasePanelWidth + mainWordPanelWidth, margin, dataBasePanelWidth,
                dataBasePanelHeight, veryLightGray);
        wordPanel.add(grammarPanel);

        commentPanelWidth = (wordPanelWidth - margin * 4) / 3;
        commentPanelHeight = wordPanelHeight - margin * 3 - mainWordPanelHeight;
        commentPanelLevel = mainWordPanelHeight + margin * 2;
        commentPanel = makePanel(margin, commentPanelLevel, commentPanelWidth,
                commentPanelHeight, veryLightGray);
//        commentPanel.setLayout(null);
        wordPanel.add(commentPanel);

        examplePanel = makePanel(margin * 2 + commentPanelWidth, commentPanelLevel, commentPanelWidth,
                commentPanelHeight, veryLightGray);
//        examplePanel.setLayout(null);
        wordPanel.add(examplePanel);

        tagsPanel = makePanel(margin * 3 + commentPanelWidth * 2, commentPanelLevel, commentPanelWidth,
                commentPanelHeight, veryLightGray);
//        tagsPanel.setLayout(null);
        wordPanel.add(tagsPanel);


        picturePanel = makePanel(margin, margin, commentPanelWidth, userPanelHeight - margin * 2, veryLightGray);
        userPanel.add(picturePanel);

        userActionPanel = makePanel(margin * 2 + commentPanelWidth, margin,
                userPanelWidth - margin * 3 - commentPanelWidth, userPanelHeight - margin * 2, veryLightGray);
        userPanel.add(userActionPanel);

//        ---------------------------------------------------------------------------------------------------------
//        JLabels:
        dbsLabel = makeLabel("Databases:", headerFont, JLabel.LEFT);
        dbsLabel.setBounds(labelMargin, labelMargin, 150, headerFont.getSize());
        optionsPanel.add(dbsLabel);

        feedbackLabel = makeLabel("Correct / Wrong", normalFont, JLabel.CENTER);
        mainWordPanel.add(feedbackLabel);

        wordLabel = makeLabel("Word", wordFont, JLabel.CENTER);
        mainWordPanel.add(wordLabel);

        currentDB_Label = makeLabel("Current data base:", headerFont, JLabel.LEFT);
        currentDB_Label.setBounds(labelMargin, labelMargin, 250, headerFont.getSize() + 5);
        dataBasePanel.add(currentDB_Label);

        posLabel = makeLabel("Part of speech:", headerFont, JLabel.LEFT);
        posLabel.setBounds(labelMargin, labelMargin, 250, headerFont.getSize() + 5);
        grammarPanel.add(posLabel);

        commentLabel = makeLabel("Comment:", headerFont, JLabel.LEFT);
        commentLabel.setBounds(labelMargin, labelMargin, 150, headerFont.getSize() + 5);
        commentPanel.add(commentLabel);

        exampleLabel = makeLabel("Example:", headerFont, JLabel.LEFT);
        exampleLabel.setBounds(labelMargin, labelMargin, 250, headerFont.getSize() + 5);
        examplePanel.add(exampleLabel);

        tagsLabel = makeLabel("Tags:", headerFont, JLabel.LEFT);
        tagsLabel.setBounds(labelMargin, labelMargin, 250, headerFont.getSize() + 5);
        tagsPanel.add(tagsLabel);








    }

    JPanel makePanel(int x, int y, int width, int height, Color color) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setBackground(color);
        panel.setLayout(null);
        panel.setVisible(true);
        return panel;
    }

    JLabel makeLabel(String name, Font font, int horizontalAlignment){
        JLabel label = new JLabel(name);
        label.setForeground(Color.black);
        label.setFont(font);
        label.setHorizontalAlignment(horizontalAlignment);
        label.setVisible(true);
        return label;


    }
}
