package root;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    Timer popupTimer;

    public UI ui;
    public UtilsHandler utilsHandler = new UtilsHandler();

    public static void main(String[] args) {
        new Main();
    }

    Main() {
        this.ui = new UI(this);

    }

    public class UtilsHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String utilAction = event.getActionCommand();
            switch (utilAction) {
                case "ok": ui.thanksForAnswerLabel.setVisible(true); break;
                case "nok": ui.thanksForAnswerLabel.setVisible(true); break;
                case "submit": ui.isSubmittedLabel.setVisible(true); break;
            }
        }
    }
}
