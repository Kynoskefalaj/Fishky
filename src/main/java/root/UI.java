package root;

import javax.swing.*;
import java.awt.*;

public class UI {

    JFrame window;
    Container con;

    JPanel optionsPanel, mainPanel, wordPanel, userPanel;
    JPanel dataBasePanel, mainWordPanel, grammarPanel, commentPanel, examplePanel, tagsPanel, picturePanel,
            userActionPanel;

    int windowX = 1600;
    int windowY = 900;

    int margin = 8;

    int optionsPanelWidth, mainPanelWidth, wordPanelWidth, userPanelWidth, mainWordPanelWidth, dataBasePanelWidth,
        commentPanelWidth, commentPanelLevel, wordPanelHeight, userPanelHeight, dataBasePanelHeight,
        mainWordPanelHeight, commentPanelHeight;

    Color darkGray = new Color(30, 30, 30);
    Color mediumGray = new Color (40, 40, 40);
    Color lightGray = new Color (50, 50, 50);
    Color veryLightGray = new Color (60, 60, 60);
    Color mediumPurple = new Color (70, 70, 206);

    public UI(){
        displayWindow();
        displayScreen();
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
        wordPanel.add(commentPanel);

        examplePanel = makePanel(margin * 2 + commentPanelWidth, commentPanelLevel, commentPanelWidth,
                commentPanelHeight, veryLightGray);
        wordPanel.add(examplePanel);

        tagsPanel = makePanel(margin * 3 + commentPanelWidth * 2, commentPanelLevel, commentPanelWidth,
                commentPanelHeight, veryLightGray);
        wordPanel.add(tagsPanel);


        picturePanel = makePanel(margin, margin, commentPanelWidth, userPanelHeight - margin * 2, veryLightGray);
        userPanel.add(picturePanel);

        userActionPanel = makePanel(margin * 2 + commentPanelWidth, margin,
                userPanelWidth - margin * 3 - commentPanelWidth, userPanelHeight - margin * 2, veryLightGray);
        userPanel.add(userActionPanel);
    }

    JPanel makePanel(int x, int y, int width, int height, Color color) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setBackground(color);
        panel.setVisible(true);
        return panel;
    }
}
