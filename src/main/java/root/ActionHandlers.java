package root;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandlers {

    public UI ui;
    public UtilsHandler utilsHandler = new UtilsHandler();
//    public UserActionHandler userActionHandler = new UserActionHandler();

    public ActionHandlers(UI ui) {
        this.ui = ui;
    }

    public void setUI (UI ui) {
        this.ui = ui;
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
            }
        }
    }

//    public class UserActionHandler
//}

}
