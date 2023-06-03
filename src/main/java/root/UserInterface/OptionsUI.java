package root.UserInterface;

import javax.swing.*;

public class OptionsUI extends SetupUI{

    UI ui;

    JPanel optionsPanel, menuLvl;

    public OptionsUI(UI ui) {
        this.ui = ui;
    }

    public void optionsPanelsSetup() {
//        menuLvl = UtilsUI.makePanel(ui.panel)
        optionsPanel = UtilsUI.makePanel(margin, margin, 300, windowY - margin * 2, mediumGray);
//        optionsPanel.setLayout(new GridLayout(13, 1));
        ui.con.add(optionsPanel);
    }
}
