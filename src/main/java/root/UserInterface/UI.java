package root.UserInterface;

import root.ActionHandlers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class UI extends SetupUI{

    ActionHandlers ah;
    public OptionsUI oui;

    JFrame window;
    Container con;
    public JPanel ouioptionsPanel, mainPanel, wordPanel, userPanel;
    public JPanel dataBasePanel, mainWordPanel, grammarPanel, commentPanel, examplePanel, tagsPanel, newWordPanel,
            userActionPanel;
    public JLabel dbsLabel, feedbackLabel, hiddenWordLabel, wordLabel, commentLabel, exampleLabel, tagsLabel, posLabel,
            posValueLabel, currentDB_Label, currDB_ValueLabel, hintLabel, isSubmittedLabel, checkLabel, leaveFeedbackLabel,
            isTranslationCorrectLabel, thanksForAnswerLabel;
    public JTextArea commentArea, exampleArea, tagsArea, userSuggestionsInput;
    public JCheckBox commentsCheckBox, exampleCheckBox, tagsCheckBox;
    public JTextField userWordInput;

    private int valueObjectLevel;


    private int commentPanelWidth;
    private int commentPanelHeight;

    public UI(ActionHandlers ah) {
        this.ah = ah;
        this.oui = new OptionsUI(this);
    }
    public void runUI() {
        displayWindow();
        oui.optionsPanelsSetup();
//        ui.displayScreen();
        displayPanels();
        displayLabels();
        displayCheckBoxes();
        displayTextAreas();
        displayUserActionsComponents();
    }

    public void displayWindow() {
        window = new JFrame();
        window.setSize(windowX + 13, windowY + 36);
        window.getContentPane().setBackground(darkGray);
        window.setVisible(true);
        window.setLayout(null);

        con = window.getContentPane();
    }

//    public void displayScreen() {
//        ouioptionsPanel = UtilsUI.makePanel(margin, margin, 300, windowY - margin * 2, mediumGray);
////        optionsPanel.setLayout(new GridLayout(13, 1));
//        con.add(ouioptionsPanel);
//    }

    public void displayPanels() {
        int mainPanelWidth = windowX - oui.optionsPanel.getWidth() - margin * 3;
        mainPanel = UtilsUI.makePanel(margin * 2 + oui.optionsPanel.getWidth(), margin, mainPanelWidth,
                windowY - margin * 2, mediumGray);
        mainPanel.setLayout(null); //set panel's layout to null to have control on its child's boundaries
        con.add(mainPanel);
//        mainPanel.setVisible(false);

        int wordPanelWidth = mainPanelWidth - margin * 2;
        int wordPanelHeight = 500;
        wordPanel = UtilsUI.makePanel(margin, margin, wordPanelWidth, wordPanelHeight, lightGray);
        wordPanel.setLayout(null);
        mainPanel.add(wordPanel);

        int userPanelHeight = windowY - wordPanelHeight - margin * 5;
        userPanel = UtilsUI.makePanel(margin, wordPanelHeight + margin * 2,
                wordPanelWidth, userPanelHeight, lightGray);
        userPanel.setLayout(null);
        mainPanel.add(userPanel);

        int mainWordPanelWidth = 500;
        int mainWordPanelHeight = 150;
        mainWordPanel = UtilsUI.makePanel(mainPanelWidth / 2 - mainWordPanelWidth / 2 - margin, margin,
                mainWordPanelWidth, mainWordPanelHeight, veryLightGray);
        wordPanel.add(mainWordPanel);
        mainWordPanel.setLayout(new GridLayout(2, 1));


        int dataBasePanelWidth = (wordPanelWidth - margin * 4 - mainWordPanelWidth) / 2;
        int dataBasePanelHeight = mainWordPanelHeight;
        dataBasePanel = UtilsUI.makePanel(margin, margin, dataBasePanelWidth, dataBasePanelHeight, veryLightGray);
        wordPanel.add(dataBasePanel);

        grammarPanel = UtilsUI.makePanel(margin * 3 + dataBasePanelWidth + mainWordPanelWidth, margin, dataBasePanelWidth,
                dataBasePanelHeight, veryLightGray);
        wordPanel.add(grammarPanel);

        commentPanelWidth = (wordPanelWidth - margin * 4) / 3;
        commentPanelHeight = wordPanelHeight - margin * 3 - mainWordPanelHeight;
        int commentPanelLevel = mainWordPanelHeight + margin * 2;
        commentPanel = UtilsUI.makePanel(margin, commentPanelLevel, commentPanelWidth,
                commentPanelHeight, veryLightGray);
//        commentPanel.setLayout(null);
        wordPanel.add(commentPanel);


        //changed "picturePanel" to "newWordPanel" for setting wordLabel in the very center of the screen
        newWordPanel = UtilsUI.makePanel(margin * 2 + commentPanelWidth, commentPanelLevel, commentPanelWidth,
                commentPanelHeight, veryLightGray);
        newWordPanel.setLayout(new GridBagLayout());
        wordPanel.add(newWordPanel);

        tagsPanel = UtilsUI.makePanel(margin * 3 + commentPanelWidth * 2, commentPanelLevel, commentPanelWidth,
                commentPanelHeight, veryLightGray);
//        tagsPanel.setLayout(null);
        wordPanel.add(tagsPanel);


        examplePanel = UtilsUI.makePanel(margin, margin, commentPanelWidth, userPanelHeight - margin * 2, veryLightGray);
        userPanel.add(examplePanel);

        userActionPanel = UtilsUI.makePanel(margin * 2 + commentPanelWidth, margin,
                wordPanelWidth - margin * 3 - commentPanelWidth, userPanelHeight - margin * 2, veryLightGray);
        userPanel.add(userActionPanel);
    }

    public void displayLabels() {
//        ---------------------------------------------------------------------------------------------------------
//        JLabels:
        dbsLabel = UtilsUI.makeLabel("Databases:", headerFont, JLabel.LEFT);
        dbsLabel.setBounds(margin, labelMargin, 150, headerFont.getSize());
        oui.optionsPanel.add(dbsLabel);

        feedbackLabel = UtilsUI.makeLabel("Correct / Wrong", wordFont, JLabel.CENTER);
        mainWordPanel.add(feedbackLabel);

        hiddenWordLabel = UtilsUI.makeLabel("Hidden word", wordFont, JLabel.CENTER);
        mainWordPanel.add(hiddenWordLabel);

        wordLabel = UtilsUI.makeLabel("Word", wordFont, JLabel.CENTER);
        wordLabel.setHorizontalAlignment(JLabel.CENTER);
        wordLabel.setVerticalAlignment(JLabel.CENTER);
        newWordPanel.add(wordLabel);

        currentDB_Label = UtilsUI.makeLabel("Current data base:", headerFont, JLabel.LEFT);
        currentDB_Label.setBounds(labelMargin, labelMargin, 250, headerFont.getSize() + 5);
        dataBasePanel.add(currentDB_Label);

        valueObjectLevel = labelMargin * 2 + headerFont.getSize() + 5;

        currDB_ValueLabel = UtilsUI.makeLabel("The data base", normalFont, JLabel.LEFT);
        currDB_ValueLabel.setBounds(labelMargin, valueObjectLevel, 250,
                normalFont.getSize() + 5);
        dataBasePanel.add(currDB_ValueLabel);

        posLabel = UtilsUI.makeLabel("Part of speech:", headerFont, JLabel.LEFT);
        posLabel.setBounds(labelMargin, labelMargin, 250, headerFont.getSize() + 5);
        grammarPanel.add(posLabel);

        posValueLabel = UtilsUI.makeLabel("The part of speech", normalFont, JLabel.LEFT);
        posValueLabel.setBounds(labelMargin, valueObjectLevel, 250, normalFont.getSize() + 5);
        grammarPanel.add(posValueLabel);

        commentLabel = UtilsUI.makeLabel("Comment:", headerFont, JLabel.LEFT);
        commentLabel.setBounds(labelMargin, labelMargin, 150, headerFont.getSize() + 5);
        commentPanel.add(commentLabel);

        exampleLabel = UtilsUI.makeLabel("Example:", headerFont, JLabel.LEFT);
        exampleLabel.setBounds(labelMargin, labelMargin, 250, headerFont.getSize() + 5);
        examplePanel.add(exampleLabel);

        tagsLabel = UtilsUI.makeLabel("Tags:", headerFont, JLabel.LEFT);
        tagsLabel.setBounds(labelMargin, labelMargin, 250, headerFont.getSize() + 5);
        tagsPanel.add(tagsLabel);
    }

    public void displayTextAreas() {
//        ----------------------------------------------------------------------------------------------------------
//        text areas:
        commentArea = new JTextArea();
        commentArea.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown " +
                "printer took a galley of type and scrambled it to make a type specimen book. It has survived " +
                "not only five centuries, but also the leap into electronic typesetting, remaining essentially " +
                "unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem " +
                "Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including " +
                "versions of Lorem Ipsum.");
        commentArea.setBackground(veryLightGray);
        commentArea.setBounds(labelMargin, valueObjectLevel, commentPanelWidth - 2 * labelMargin,
                commentPanelHeight - labelMargin - valueObjectLevel);
        commentArea.setFont(textFont);
        commentArea.setForeground(veryDarkGray);
        commentArea.setLineWrap(true);
        commentArea.setEditable(false);
        commentPanel.add(commentArea);

        exampleArea = new JTextArea();
        exampleArea.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown " +
                "printer took a galley of type and scrambled it to make a type specimen book. It has survived " +
                "not only five centuries, but also the leap into electronic typesetting, remaining essentially " +
                "unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem " +
                "Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including " +
                "versions of Lorem Ipsum.");
        exampleArea.setBackground(veryLightGray);
        exampleArea.setBounds(labelMargin, valueObjectLevel, commentPanelWidth - 2 * labelMargin,
                commentPanelHeight - labelMargin - valueObjectLevel);
        exampleArea.setFont(textFont);
        exampleArea.setForeground(veryDarkGray);
        exampleArea.setLineWrap(true);
        exampleArea.setEditable(false);
        examplePanel.add(exampleArea);

        tagsArea = new JTextArea();
        tagsArea.setText("Tag1, Tag2, Tag3, Tag4 ...");
        tagsArea.setBackground(veryLightGray);
        tagsArea.setBounds(labelMargin, valueObjectLevel, commentPanelWidth - 2 * labelMargin,
                commentPanelHeight - labelMargin - valueObjectLevel);
        tagsArea.setFont(textFont);
        tagsArea.setForeground(veryDarkGray);
        tagsArea.setLineWrap(true);
        tagsArea.setEditable(false);
        tagsPanel.add(tagsArea);
    }

    public void displayCheckBoxes() {
//        ----------------------------------------------------------------------------------------------------------
//        check boxes:
        commentsCheckBox = new JCheckBox();
        commentsCheckBox.setBounds(commentPanelWidth - 20 - labelMargin, labelMargin, 20, 20);
        commentsCheckBox.setBackground(veryLightGray);
        commentsCheckBox.setMnemonic(KeyEvent.VK_C);
        commentsCheckBox.setSelected(true);
        commentsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    commentArea.setVisible(true);
                } else
                    commentArea.setVisible(false);
            }
        });
        commentPanel.add(commentsCheckBox);

        exampleCheckBox = new JCheckBox();
        exampleCheckBox.setBounds(commentPanelWidth - 20 - labelMargin, labelMargin, 20, 20);
        exampleCheckBox.setBackground(veryLightGray);
        exampleCheckBox.setMnemonic(KeyEvent.VK_E);
        exampleCheckBox.setSelected(true);
        exampleCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    exampleArea.setVisible(true);
                } else
                    exampleArea.setVisible(false);
            }
        });
        examplePanel.add(exampleCheckBox);

        tagsCheckBox = new JCheckBox();
        tagsCheckBox.setBounds(commentPanelWidth - 20 - labelMargin, labelMargin, 20, 20);
        tagsCheckBox.setBackground(veryLightGray);
        tagsCheckBox.setMnemonic(KeyEvent.VK_T);
        tagsCheckBox.setSelected(true);
        tagsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    tagsArea.setVisible(true);
                } else
                    tagsArea.setVisible(false);
            }
        });
        tagsPanel.add(tagsCheckBox);

//        newWordCheckBox = new JCheckBox();
//        newWordCheckBox.setBounds(commentPanelWidth - 20 - labelMargin, labelMargin, 20, 20);
//        newWordCheckBox.setBackground(veryLightGray);
//        newWordCheckBox.setMnemonic(KeyEvent.VK_P);
//        newWordCheckBox.setSelected(true);
//        newWordCheckBox.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
////                    picture.setVisible(true);
//                }
////                else
////                    picture.setVisible(false);
//            }
//        });
//        newWordPanel.add(newWordCheckBox);
    }

    public void displayUserActionsComponents() {
//        --------------------------------------------------------------------------------------------------------------
//        components on userActionPanel
        userWordInput = new JTextField();
        userWordInput.setBounds(labelMargin, labelMargin, examplePanel.getWidth() - labelMargin * 2, 40);
        userWordInput.setFont(normalFont);
        userWordInput.setHorizontalAlignment(JTextField.CENTER);
        userWordInput.setBackground(mediumPurple);
        userWordInput.setForeground(Color.black);
        userWordInput.setBorder(BorderFactory.createLineBorder(mediumGray));
        userActionPanel.add(userWordInput);

        enterButton = UtilsUI.makeButton("Enter", buttonFont, examplePanel.getWidth(), labelMargin,
                (tagsPanel.getWidth() + margin - 3 * labelMargin) / 3, userWordInput.getHeight(), mediumPurple);
        enterButton.addActionListener(ah.userActionHandler);
        enterButton.setActionCommand("ENTER");
        enterButton.addKeyListener(new ActionHandlers.confirmationKeyListener());
        userActionPanel.add(enterButton);

        nextButton = UtilsUI.makeButton("Next", buttonFont, enterButton.getX() + enterButton.getWidth() + labelMargin,
                labelMargin, enterButton.getWidth(), userWordInput.getHeight(), mediumPurple);
        nextButton.addActionListener(ah.userActionHandler);
        nextButton.setActionCommand("next");
        nextButton.addKeyListener(new ActionHandlers.confirmationKeyListener());
        userActionPanel.add(nextButton);

        checkButton = UtilsUI.makeButton("Check", buttonFont, nextButton.getX() + nextButton.getWidth() + labelMargin,
                labelMargin, enterButton.getWidth(), userWordInput.getHeight(), mediumPurple);
        checkButton.addActionListener(ah.userActionHandler);
        checkButton.setActionCommand("check");
        checkButton.addKeyListener(new ActionHandlers.confirmationKeyListener());
        userActionPanel.add(checkButton);

        hintLabel = UtilsUI.makeLabel("This is hint", normalFont, JLabel.LEFT);
        hintLabel.setBounds(labelMargin, userWordInput.getHeight() + 2 * labelMargin, userWordInput.getWidth(),
                userWordInput.getHeight());
        userActionPanel.add(hintLabel);

        hintButton = UtilsUI.makeButton("Hint", buttonFont, enterButton.getX(), hintLabel.getY(), enterButton.getWidth(),
                enterButton.getHeight(), mediumPurple);
        hintButton.addActionListener(ah.userActionHandler);
        hintButton.setActionCommand("hint");
        hintButton.addKeyListener(new ActionHandlers.confirmationKeyListener());
        userActionPanel.add(hintButton);

        checkLabel = UtilsUI.makeLabel("Check answer", normalFont, JLabel.CENTER);
        checkLabel.setBounds(nextButton.getX(), hintLabel.getY(), checkButton.getWidth() * 2 + labelMargin,
                hintLabel.getHeight());
        userActionPanel.add(checkLabel);

        userSuggestionsInput = new JTextArea();
        userSuggestionsInput.setBounds(labelMargin, userActionPanel.getHeight() - 3 * (enterButton.getHeight() + labelMargin),
                nextButton.getX() - 2 * labelMargin,userActionPanel.getHeight() - 200 - labelMargin);
        userSuggestionsInput.setBackground(veryLightGray);
        userSuggestionsInput.setFont(textFont);
        userSuggestionsInput.setForeground(veryDarkGray);
        userSuggestionsInput.setLineWrap(true);
        userSuggestionsInput.setBorder(BorderFactory.createLineBorder(lightGray));
        userActionPanel.add(userSuggestionsInput);

        leaveFeedbackLabel = UtilsUI.makeLabel("Leave feedback below:", smallHeaderFont, JLabel.LEFT);
        leaveFeedbackLabel.setBounds(labelMargin, userSuggestionsInput.getY() - hintLabel.getHeight(),
                userSuggestionsInput.getWidth(), hintLabel.getHeight());
        leaveFeedbackLabel.setForeground(veryDarkGray);
        userActionPanel.add(leaveFeedbackLabel);

        isTranslationCorrectLabel = UtilsUI.makeLabel("Is translation correct?", smallHeaderFont, JLabel.CENTER);
        isTranslationCorrectLabel.setBounds(nextButton.getX(), leaveFeedbackLabel.getY(),
                nextButton.getWidth() * 2 + labelMargin, leaveFeedbackLabel.getHeight());
        userActionPanel.add(isTranslationCorrectLabel);

        okButton = UtilsUI.makeButton("Yes", buttonFont, nextButton.getX(), userSuggestionsInput.getY(),
                nextButton.getWidth(), nextButton.getHeight(), mediumPurple);
        okButton.setBackground(goodColor);
        okButton.addActionListener(ah.utilsHandler);
        okButton.setActionCommand("ok");
        okButton.addKeyListener(new ActionHandlers.confirmationKeyListener());
        userActionPanel.add(okButton);

        nokButton = UtilsUI.makeButton("No", buttonFont, checkButton.getX(), userSuggestionsInput.getY(),
                nextButton.getWidth(), nextButton.getHeight(), mediumPurple);
        nokButton.setBackground(badColor);
        nokButton.addActionListener(ah.utilsHandler);
        nokButton.setActionCommand("nok");
        nokButton.addKeyListener(new ActionHandlers.confirmationKeyListener());
        userActionPanel.add(nokButton);

        thanksForAnswerLabel = UtilsUI.makeLabel("Thank you for your answer", notificationFont, JLabel.CENTER);
        thanksForAnswerLabel.setBounds(okButton.getX(), okButton.getY() + okButton.getHeight() + labelMargin,
                okButton.getWidth() * 2 + labelMargin, okButton.getHeight());
        thanksForAnswerLabel.setVisible(false);
        userActionPanel.add(thanksForAnswerLabel);

        submitButton = UtilsUI.makeButton("Submit", buttonFont, okButton.getX(),
                thanksForAnswerLabel.getY() + labelMargin + thanksForAnswerLabel.getHeight(), nextButton.getWidth(),
                nextButton.getHeight(), mediumPurple);
        submitButton.addActionListener(ah.utilsHandler);
        submitButton.setActionCommand("submit");
        submitButton.addKeyListener(new ActionHandlers.confirmationKeyListener());
        userActionPanel.add(submitButton);

        isSubmittedLabel = UtilsUI.makeLabel("Submitted", notificationFont, JLabel.CENTER);
        isSubmittedLabel.setBounds(nokButton.getX(), submitButton.getY(), nokButton.getWidth(), submitButton.getHeight());
        isSubmittedLabel.setForeground(goodColor);
        isSubmittedLabel.setVisible(false);
        userActionPanel.add(isSubmittedLabel);

        //-----------------------------------------------------------------------------------------------------------
        helpButton = UtilsUI.makeButton("", buttonFont, userActionPanel.getWidth() - margin - 50,
                userSuggestionsInput.getY() - margin - 50 - isTranslationCorrectLabel.getHeight(), 50,
                50, mediumPurple);
        helpButton.setBackground(mediumPurple);
        helpButton.addActionListener(ah.utilsHandler);
        helpButton.setActionCommand("help");

        userActionPanel.add(helpButton);

        helpIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("icons/help.png")));
        Image helpImage = helpIcon.getImage();
        Image resizedHelpImage = helpImage.getScaledInstance(helpButton.getWidth() - 2,
                helpButton.getHeight() - 2, Image.SCALE_SMOOTH);
        ImageIcon resizedHelpIcon = new ImageIcon(resizedHelpImage);
        helpButton.setIcon(resizedHelpIcon);
//        starButton.setBorder(BorderFactory.createEmptyBorder());

        exclamationButton = UtilsUI.makeButton("", buttonFont, helpButton.getX() - margin - 50,
                helpButton.getY(), helpButton.getWidth(), helpButton.getHeight(), mediumPurple);
        exclamationButton.setBackground(mediumPurple);
        exclamationButton.addActionListener(ah.utilsHandler);
        exclamationButton.setActionCommand("exclamation");
        exclamationButton.addKeyListener(new ActionHandlers.confirmationKeyListener());
        userActionPanel.add(exclamationButton);

        exclamationIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("icons/exclamation_mark.png")));
        Image exclamationImage = exclamationIcon.getImage();
        Image resizedExclamationImage = exclamationImage.getScaledInstance(exclamationButton.getWidth() - 15,
                exclamationButton.getHeight() - 15, Image.SCALE_SMOOTH);
        ImageIcon resizedExclamationIcon = new ImageIcon(resizedExclamationImage);
        exclamationButton.setIcon(resizedExclamationIcon);
//        heartButton.setBorder(BorderFactory.createEmptyBorder());


        heartButton = UtilsUI.makeButton("", buttonFont, exclamationButton.getX() - margin - 50,
                helpButton.getY(), helpButton.getWidth(), helpButton.getHeight(), mediumPurple);
        heartButton.setBackground(mediumPurple);
        heartButton.addActionListener(ah.utilsHandler);
        heartButton.setActionCommand("heart");
        heartButton.addKeyListener(new ActionHandlers.confirmationKeyListener());
        userActionPanel.add(heartButton);

        heartIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("icons/heart.png")));
        Image heartImage = heartIcon.getImage();
        Image resizedHeartImage = heartImage.getScaledInstance(heartButton.getWidth() - 15,
                heartButton.getHeight() - 15, Image.SCALE_SMOOTH);
        ImageIcon resizedHeartIcon = new ImageIcon(resizedHeartImage);
        heartButton.setIcon(resizedHeartIcon);
//        heartButton.setBorder(BorderFactory.createEmptyBorder());

        starButton = UtilsUI.makeButton("", buttonFont, heartButton.getX() - margin - 50,
                heartButton.getY(), heartButton.getWidth(), heartButton.getHeight(), mediumPurple);
        starButton.setBackground(mediumPurple);
        starButton.addActionListener(ah.utilsHandler);
        starButton.addKeyListener(new ActionHandlers.confirmationKeyListener());
        starButton.setActionCommand("star");

        userActionPanel.add(starButton);

        starIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("icons/star.png")));
        Image starImage = starIcon.getImage();
        Image resizedStarImage = starImage.getScaledInstance(starButton.getWidth() - 10,
                starButton.getHeight() - 10, Image.SCALE_SMOOTH);
        ImageIcon resizedStarIcon = new ImageIcon(resizedStarImage);
        starButton.setIcon(resizedStarIcon);

        //-----------------------------------------------------------------------------------------------------------
        dbTotalButton = UtilsUI.makeButton("Total", buttonFont, dbsLabel.getX(),
                dbsLabel.getY() + dbsLabel.getHeight() + margin, oui.optionsPanel.getWidth() - 2 * margin,
                40, mediumPurple);
        dbTotalButton.addActionListener(ah.navigateHandler);
        dbTotalButton.setActionCommand("total");
        oui.optionsPanel.add(dbTotalButton);

        dbThemesButton = UtilsUI.makeButton("Themes", buttonFont, dbsLabel.getX(),
                dbTotalButton.getY() + dbTotalButton.getHeight() + margin/2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbThemesButton.addActionListener(ah.navigateHandler);
        dbThemesButton.setActionCommand("themes");
        oui.optionsPanel.add(dbThemesButton);

        dbRepetitionButton = UtilsUI.makeButton("Repetition", buttonFont, dbsLabel.getX(),
                dbThemesButton.getY() + dbThemesButton.getHeight() + margin/2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbRepetitionButton.addActionListener(ah.navigateHandler);
        dbRepetitionButton.setActionCommand("repetition");
        oui.optionsPanel.add(dbRepetitionButton);

        dbMarkedButton = UtilsUI.makeButton("Marked", buttonFont, dbsLabel.getX(),
                dbRepetitionButton.getY() + dbTotalButton.getHeight() + margin/2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbMarkedButton.addActionListener(ah.navigateHandler);
        dbMarkedButton.setActionCommand("marked");
        oui.optionsPanel.add(dbMarkedButton);

        dbSearchEngineButton = UtilsUI.makeButton("Search Engine", buttonFont, dbsLabel.getX(),
                dbMarkedButton.getY() + dbTotalButton.getHeight() + margin/2, dbTotalButton.getWidth(),
                dbTotalButton.getHeight(), mediumPurple);
        dbSearchEngineButton.addActionListener(ah.navigateHandler);
        dbSearchEngineButton.setActionCommand("search engine");
        oui.optionsPanel.add(dbSearchEngineButton);


    }

    public void setFeedback(Boolean isCorrect){
        if (isCorrect) {
            feedbackLabel.setText("CORRECT");
            feedbackLabel.setForeground(goodColor);
        } else {
            feedbackLabel.setText("WRONG!");
            feedbackLabel.setForeground(badColor);}
    }
}
