package root.UserInterface;

import javax.swing.*;
import java.awt.*;

public class UtilsUI{

    public static JPanel makePanel(int x, int y, int width, int height, Color color) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setBackground(color);
        panel.setLayout(null);
        panel.setVisible(true);
        return panel;
    }

    public static JLabel makeLabel(String name, Font font, int horizontalAlignment){
        JLabel label = new JLabel(name);
        label.setForeground(Color.black);
        label.setFont(font);
        label.setHorizontalAlignment(horizontalAlignment);
        label.setVisible(true);
        return label;
    }

    public static JButton makeButton(String name, Font font, int x, int y, int width, int height, Color color){
        JButton button = new JButton(name);
        button.setBounds(x, y, width, height);
        button.setForeground(Color.black);
        button.setBackground(color);
        button.setBorder(BorderFactory.createLineBorder(SetupUI.mediumGray));
        button.setFont(font);

        return button;
    }
}
