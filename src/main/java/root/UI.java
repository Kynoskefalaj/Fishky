package root;

import javax.swing.*;
import java.awt.*;

public class UI {

    JFrame window;
    Container con;

    int windowX = 1600;
    int windowY = 900;

    public UI(){
        displayWindow();
    }

    void displayWindow() {
        window = new JFrame();
        window.setSize(windowX + 13, windowY + 36);
        window.getContentPane().setBackground(new Color (30, 30, 30));
        window.setVisible(true);
        window.setLayout(null);

        con = window.getContentPane();
    }

}
