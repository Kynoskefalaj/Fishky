package root;

import root.UserInterface.OptionsUI;
import root.UserInterface.SetupUI;
import root.UserInterface.UI;

public class Main {
    public ActionHandlers ah = new ActionHandlers(null);
    SetupUI sui = new SetupUI();
    public UI ui = new UI(ah);
    public Mechanics mechanics = new Mechanics(ui);

    public static void main(String[] args){
        new Main();
    }

    Main(){
        // dependency injection
        ah.setUI(ui);
        ah.setMech(mechanics);
        sui.mechanicsDependencyInjection(mechanics);
        ui.runUI();

        mechanics.setRandomWordLabels();
    }

}
