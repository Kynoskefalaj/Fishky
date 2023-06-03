package root.UserInterface;

import javax.swing.*;

public class OptionsUI extends SetupUI{

    UI ui;

    public JPanel menuPanel, totalPanel;
    JLabel dbsLabel;

    public OptionsUI(UI ui) {
        this.ui = ui;
    }

    public void menuPanelsSetup() {
        menuPanel = UtilsUI.makePanel(margin, margin, 300, windowY - margin * 2, mediumGray);
        ui.con.add(menuPanel);

        dbsLabel = UtilsUI.makeLabel("Databases:", headerFont, JLabel.LEFT);
        dbsLabel.setBounds(margin, labelMargin, 150, headerFont.getSize());
        menuPanel.add(dbsLabel);

        dbTotalButton = UtilsUI.makeButton("Total", buttonFont, dbsLabel.getX(),
                dbsLabel.getY() + dbsLabel.getHeight() + margin, menuPanel.getWidth() - 2 * margin,
                40, mediumPurple);
        dbTotalButton.addActionListener(ui.ah.navigateHandler);
        dbTotalButton.setActionCommand("total");
        menuPanel.add(dbTotalButton);

        dbThemesButton = UtilsUI.makeButton("Themes", buttonFont, dbsLabel.getX(),
                dbTotalButton.getY() + dbTotalButton.getHeight() + margin/2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbThemesButton.addActionListener(ui.ah.navigateHandler);
        dbThemesButton.setActionCommand("themes");
        menuPanel.add(dbThemesButton);

        dbRepetitionButton = UtilsUI.makeButton("Repetition", buttonFont, dbsLabel.getX(),
                dbThemesButton.getY() + dbThemesButton.getHeight() + margin/2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbRepetitionButton.addActionListener(ui.ah.navigateHandler);
        dbRepetitionButton.setActionCommand("repetition");
        menuPanel.add(dbRepetitionButton);

        dbMarkedButton = UtilsUI.makeButton("Marked", buttonFont, dbsLabel.getX(),
                dbRepetitionButton.getY() + dbTotalButton.getHeight() + margin/2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbMarkedButton.addActionListener(ui.ah.navigateHandler);
        dbMarkedButton.setActionCommand("marked");
        menuPanel.add(dbMarkedButton);

        dbSearchEngineButton = UtilsUI.makeButton("Search Engine", buttonFont, dbsLabel.getX(),
                dbMarkedButton.getY() + dbTotalButton.getHeight() + margin/2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbSearchEngineButton.addActionListener(ui.ah.navigateHandler);
        dbSearchEngineButton.setActionCommand("search engine");
        menuPanel.add(dbSearchEngineButton);
    }

    public void totalPanelSetup() {
        totalPanel = UtilsUI.makePanel(menuPanel.getX(), menuPanel.getY(), menuPanel.getWidth(), menuPanel.getHeight(),
                mediumGray);
        ui.con.add(totalPanel);
        totalPanel.setVisible(false);
    }
}
