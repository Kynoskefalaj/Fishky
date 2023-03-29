package root;

import javax.swing.*;
import java.awt.*;

public class UI {

    JFrame window;
    Container con;

    JPanel optionsPanel, mainPanel;

    int windowX = 1600;
    int windowY = 900;

    int optionsPanelWidth, mainPanelWidth;

    Color darkGray = new Color(30, 30, 30);
    Color mediumGray = new Color (50, 50, 50);
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
        optionsPanel = makePanel(10, 10, optionsPanelWidth, windowY - 20, mediumGray);
        con.add(optionsPanel);

        mainPanelWidth = windowX - optionsPanelWidth - 30;
        mainPanel = makePanel(20 + optionsPanelWidth, 10, mainPanelWidth,
                windowY - 20, mediumGray);
        con.add(mainPanel);


    }

    JPanel makePanel(int x, int y, int width, int height, Color color) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setBackground(color);
        return panel;
    }
}
