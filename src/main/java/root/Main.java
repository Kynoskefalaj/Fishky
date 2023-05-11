package root;

import java.io.IOException;

public class Main {
    public ActionHandlers ah = new ActionHandlers(null);
    public UI ui = new UI(ah);
    public Mechanics mechanics;

    public static void main(String[] args){
        new Main();
    }

    Main(){
        // dependency injection
        ah.setUI(ui);

        ui.displayWindow();
        ui.displayScreen();
        ui.displayPanels();
        ui.displayLabels();
        ui.displayCheckBoxes();
        ui.displayTextAreas();
        ui.displayUserActionsComponents();

        this.mechanics = new Mechanics(ui);
    }

}
