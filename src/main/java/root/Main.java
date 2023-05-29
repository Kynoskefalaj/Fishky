package root;

import root.UserInterface.UI;
import root.UserInterface.UtilsUI;

public class Main {
    public ActionHandlers ah = new ActionHandlers(null);
    public UI ui = new UI(ah);
    UtilsUI utUI = new UtilsUI(ui);
    public Mechanics mechanics;

    public static void main(String[] args){
        new Main();
    }

    Main(){
        // dependency injection
        ah.setUI(ui);
        this.mechanics = new Mechanics(ui);
        ah.setMech(mechanics);

        ui.displayWindow();
        ui.displayScreen();
        ui.displayPanels();
        ui.displayLabels();
        ui.displayCheckBoxes();
        ui.displayTextAreas();
        ui.displayUserActionsComponents();


        mechanics.setRandomWordLabels();
    }

}
