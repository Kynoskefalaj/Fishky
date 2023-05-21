package root;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ActionHandlers {

    public UI ui;
    public Mechanics mech;
    public UtilsHandler utilsHandler = new UtilsHandler();
    public UserActionHandler userActionHandler = new UserActionHandler();

    public ActionHandlers(UI ui) {
        this.ui = ui;
    }

    public void setUI (UI ui) {
        this.ui = ui;
    }

    public void setMech (Mechanics mech) {
        this.mech = mech;
    }

    public class UtilsHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String utilAction = event.getActionCommand();
            switch (utilAction) {
                case "ok":
                    ui.thanksForAnswerLabel.setVisible(true);
                    ui.thanksForAnswerLabel.setForeground(ui.goodColor);
                    break;
                case "nok":
                    ui.thanksForAnswerLabel.setForeground(ui.badColor);
                    ui.thanksForAnswerLabel.setVisible(true);
                    break;
                case "submit": ui.isSubmittedLabel.setVisible(true); break;
                case "heart":
                    //something after clicking heart
                    break;
                case "star":
                    //something after clicking star
                    break;
                case "exclamation":
                    //something after clicking exclamation
                    break;
                case "help":
                    //something after clicking help
                    break;
            }
        }
    }

    public class UserActionHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String userAction = event.getActionCommand();
            switch (userAction) {
                case "ENTER":
                    //something after clicking enter
                    mech.checkAnswer();
                    break;
                case "next":
                    mech.notificationsReset();
                    mech.generateRandomWordResultSet();
                    mech.setRandomWordLabels();
                    //setHiddenCorrectAnswer
                    break;
                case "check":
                    //something after clicking check
                    break;
                case "hint":
                    mech.hintDiscover();
                    //something after clicking hint
                    break;
            }
        }
    }

    static class confirmationKeyListener implements java.awt.event.KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                JButton button = (JButton) e.getComponent();
                button.doClick();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }

}
