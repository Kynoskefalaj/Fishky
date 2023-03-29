package root;

import javax.swing.*;
import java.awt.*;

public class UI {

    JFrame window;
    Container con;

    JPanel optionsPanel, mainPanel, wordPanel, userPanel;
    JPanel dataBasePanel, grammarPanel, commentPanel, examplePanel, tagsPanel, picturePanel;

    int windowX = 1600;
    int windowY = 900;

    int optionsPanelWidth, mainPanelWidth, wordPanelWidth, userPanelWidth;
    int wordPanelHeight, userPanelHeight;

    Color darkGray = new Color(30, 30, 30);
    Color mediumGray = new Color (50, 50, 50);
    Color lightGray = new Color (80, 80, 80);
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
        optionsPanel = makePanel(5, 5, optionsPanelWidth, windowY - 10, mediumGray);
        con.add(optionsPanel);

        mainPanelWidth = windowX - optionsPanelWidth - 15;
        mainPanel = makePanel(10 + optionsPanelWidth, 5, mainPanelWidth,
                windowY - 10, mediumGray);
        mainPanel.setLayout(null);
        con.add(mainPanel);
//        mainPanel.setVisible(false);

        wordPanelWidth = mainPanelWidth - 10;
        wordPanelHeight = 500;
        wordPanel = makePanel(5, 5, wordPanelWidth, wordPanelHeight, lightGray);
//        wordPanel.setPreferredSize(new Dimension(wordPanelWidth, wordPanelHeight));
        mainPanel.add(wordPanel);

        userPanelWidth = wordPanelWidth;
        userPanelHeight = windowY - wordPanelHeight - 25;
        userPanel = makePanel(5,wordPanelHeight + 10,
                userPanelWidth, userPanelHeight, lightGray);
        mainPanel.add(userPanel);




    }

    JPanel makePanel(int x, int y, int width, int height, Color color) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setBackground(color);
        panel.setVisible(true);
        return panel;
    }
}
