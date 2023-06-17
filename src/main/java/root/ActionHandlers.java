package root;

import root.UserInterface.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ActionHandlers {

    public UI ui;
    public Mechanics mech;
    public UtilsHandler utilsHandler = new UtilsHandler();
    public UserActionHandler userActionHandler = new UserActionHandler();
    public NavigateHandler navigateHandler = new NavigateHandler();

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
                    ui.hiddenWordLabel.setVisible(true);
                    break;
                case "hint":
                    mech.hintDiscover();
                    //something after clicking hint
                    break;
            }
        }
    }

    public static class confirmationKeyListener implements java.awt.event.KeyListener {
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

    public class NavigateHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String userAction = event.getActionCommand();
            switch (userAction) {
                case "total":
                    //something after clicking total
                    mech.databaseName = "Total";
                    ui.oui.menuPanel.setVisible(false);
                    ui.oui.totalPanel.setVisible(true);
                    mech.dataBasePanelSetUp();
                    break;
                case "themes":
                    //something after clicking themes
                    ui.oui.menuPanel.setVisible(false);
                    ui.oui.themesPanel.setVisible(true);
                    break;
                case "repetition":
                    //something after clicking repetition
                    ui.oui.menuPanel.setVisible(false);
                    ui.oui.repetitionPanel.setVisible(true);
                    break;
                case "marked":
                    //something after clicking marked
                    ui.oui.menuPanel.setVisible(false);
                    ui.oui.markedPanel.setVisible(true);
                    break;
                case "searchEngine":
                    //something after clicking searchEngine
                    ui.oui.menuPanel.setVisible(false);
                    ui.oui.searchEnginePanel.setVisible(true);
                    break;
                case "totReturn":
                    ui.oui.totalPanel.setVisible(false);
                    ui.oui.menuPanel.setVisible(true);
                    break;
                case "total 1":
                    Mechanics.minWordIndex = 1;
                    Mechanics.maxWordIndex = 50;
                    break;
                case "total 2":
                    Mechanics.minWordIndex = 51;
                    Mechanics.maxWordIndex = 100;
                    break;
                case "total 3":
                    Mechanics.minWordIndex = 101;
                    Mechanics.maxWordIndex = 150;
                    break;
                case "total 4":
                    Mechanics.minWordIndex = 151;
                    Mechanics.maxWordIndex = 200;
                    break;
                case "total 5":
                    Mechanics.minWordIndex = 201;
                    Mechanics.maxWordIndex = 250;
                    break;
                case "total 6":
                    Mechanics.minWordIndex = 251;
                    Mechanics.maxWordIndex = 300;
                    break;
                case "total 7":
                    Mechanics.minWordIndex = 301;
                    Mechanics.maxWordIndex = 350;
                    break;
                case "total 8":
                    Mechanics.minWordIndex = 351;
                    Mechanics.maxWordIndex = 400;
                    break;
                case "total 9":
                    Mechanics.minWordIndex = 401;
                    Mechanics.maxWordIndex = 450;
                    break;
                case "total 10":
                    Mechanics.minWordIndex = 451;
                    Mechanics.maxWordIndex = 500;
                    break;
                case "total 11":
                    Mechanics.minWordIndex = 501;
                    Mechanics.maxWordIndex = 550;
                    break;
                case "total 12":
                    Mechanics.minWordIndex = 551;
                    Mechanics.maxWordIndex = 600;
                    break;
                case "total 13":
                    Mechanics.minWordIndex = 601;
                    Mechanics.maxWordIndex = 650;
                    break;
                case "total 14":
                    Mechanics.minWordIndex = 651;
                    Mechanics.maxWordIndex = 700;
                    break;
                case "total 15":
                    Mechanics.minWordIndex = 701;
                    Mechanics.maxWordIndex = 750;
                    break;
                case "total 16":
                    Mechanics.minWordIndex = 751;
                    Mechanics.maxWordIndex = 800;
                    break;
                case "total 17":
                    Mechanics.minWordIndex = 801;
                    Mechanics.maxWordIndex = 850;
                    break;
                case "total 18":
                    Mechanics.minWordIndex = 851;
                    Mechanics.maxWordIndex = 900;
                    break;
                case "total 19":
                    Mechanics.minWordIndex = 901;
                    Mechanics.maxWordIndex = 950;
                    break;
                case "total 20":
                    Mechanics.minWordIndex = 951;
                    Mechanics.maxWordIndex = Mechanics.totalWordsQty;
                    break;

                case "themesReturn":
                    ui.oui.themesPanel.setVisible(false);
                    ui.oui.menuPanel.setVisible(true);
                    break;

                case "markedReturn":
                    ui.oui.markedPanel.setVisible(false);
                    ui.oui.menuPanel.setVisible(true);
                    break;

                case "repetitionReturn":
                    ui.oui.repetitionPanel.setVisible(false);
                    ui.oui.menuPanel.setVisible(true);
                    break;

                case "searchEngineReturn":
                    ui.oui.searchEnginePanel.setVisible(false);
                    ui.oui.menuPanel.setVisible(true);
                    break;


            }
            mech.dataBasePanelSetUp();
        }
    }



}
