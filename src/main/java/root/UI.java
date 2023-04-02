package root;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

public class UI {

    Main main;

    JFrame window;
    Container con;

    JPanel optionsPanel, mainPanel, wordPanel, userPanel;
    JPanel dataBasePanel, mainWordPanel, grammarPanel, commentPanel, examplePanel, tagsPanel, picturePanel,
            userActionPanel;
    JLabel dbsLabel, feedbackLabel, wordLabel, commentLabel, exampleLabel, tagsLabel, posLabel, posValueLabel,
            currentDB_Label, currDB_ValueLabel, hintLabel, isSubmittedLabel, checkLabel, leaveFeedbackLabel,
            isTranslationCorrectLabel, thanksForAnswerLabel;
    JTextArea commentArea, exampleArea, tagsArea, userSuggestionsInput;
    JCheckBox commentsCheckBox, exampleCheckBox, tagsCheckBox, pictureCheckBox;
    JTextField userWordInput;
    JButton enterButton, nextButton, checkButton, hintButton, okButton, nokButton, submitButton;


    int windowX = 1600;
    int windowY = 900;

    int margin = 8;
    int labelMargin = 5;

    int optionsPanelWidth, mainPanelWidth, wordPanelWidth, userPanelWidth, mainWordPanelWidth, dataBasePanelWidth,
        commentPanelWidth, commentPanelLevel, wordPanelHeight, userPanelHeight, dataBasePanelHeight,
        mainWordPanelHeight, commentPanelHeight;

    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font headerFont = new Font("Times New Roman", Font.BOLD, 30);
    Font wordFont = new Font("Arial", Font.BOLD, 45);
    Font textFont = new Font("Times New Roman", Font.PLAIN, 19);
    Font buttonFont = new Font("Arial", Font.BOLD, 25);
    Font smallHeaderFont = new Font("Times New Roman", Font.PLAIN, 25);

    Color veryDarkGray = new Color(15, 15, 15);
    Color darkGray = new Color(30, 30, 30);
    Color mediumGray = new Color (40, 40, 40);
    Color lightGray = new Color (50, 50, 50);
    Color veryLightGray = new Color (60, 60, 60);
    Color mediumPurple = new Color (70, 70, 206);
    Color goodColor = new Color(48, 206, 59);
    Color badColor = new Color(187, 66, 66);

    public UI(Main main) {
        this.main = main;
        displayWindow();
        displayScreen();

    }

    void displayWindow() {
        window = new JFrame();
        window.setSize(windowX + 13, windowY + 36);
        window.getContentPane().setBackground(darkGray);
        window.setVisible(true);
        window.setLayout(null);

        con = window.getContentPane();
    }

    JPanel makePanel(int x, int y, int width, int height, Color color) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setBackground(color);
        panel.setLayout(null);
        panel.setVisible(true);
        return panel;
    }

    JLabel makeLabel(String name, Font font, int horizontalAlignment){
        JLabel label = new JLabel(name);
        label.setForeground(Color.black);
        label.setFont(font);
        label.setHorizontalAlignment(horizontalAlignment);
        label.setVisible(true);
        return label;
    }

    JButton makeButton(String name, Font font, int x, int y, int width, int height, Color color){
        JButton button = new JButton(name);
        button.setBounds(x, y, width, height);
        button.setForeground(Color.black);
        button.setBackground(color);
        button.setBorder(BorderFactory.createLineBorder(mediumGray));
        button.setFont(font);

        return button;
    }

    void displayScreen() {
        optionsPanelWidth = 300;
        optionsPanel = makePanel(margin, margin, optionsPanelWidth, windowY - margin * 2, mediumGray);
        optionsPanel.setLayout(new GridLayout(13, 1));
        con.add(optionsPanel);

        mainPanelWidth = windowX - optionsPanelWidth - margin * 3;
        mainPanel = makePanel(margin * 2 + optionsPanelWidth, margin, mainPanelWidth,
                windowY - margin * 2, mediumGray);
        mainPanel.setLayout(null); //set panel's layout to null to have control on its child's boundaries
        con.add(mainPanel);
//        mainPanel.setVisible(false);

        wordPanelWidth = mainPanelWidth - margin * 2;
        wordPanelHeight = 500;
        wordPanel = makePanel(margin, margin, wordPanelWidth, wordPanelHeight, lightGray);
        wordPanel.setLayout(null);
        mainPanel.add(wordPanel);

        userPanelWidth = wordPanelWidth;
        userPanelHeight = windowY - wordPanelHeight - margin * 5;
        userPanel = makePanel(margin,wordPanelHeight + margin * 2,
                userPanelWidth, userPanelHeight, lightGray);
        userPanel.setLayout(null);
        mainPanel.add(userPanel);

        mainWordPanelWidth = 500;
        mainWordPanelHeight = 150;
        mainWordPanel = makePanel(mainPanelWidth/2 - mainWordPanelWidth/2 - margin, margin,
                mainWordPanelWidth, mainWordPanelHeight, veryLightGray);
        wordPanel.add(mainWordPanel);
        mainWordPanel.setLayout(new GridLayout(2, 1));


        dataBasePanelWidth = (wordPanelWidth - margin * 4 - mainWordPanelWidth) / 2;
        dataBasePanelHeight = mainWordPanelHeight;
        dataBasePanel = makePanel(margin, margin, dataBasePanelWidth, dataBasePanelHeight, veryLightGray);
        wordPanel.add(dataBasePanel);

        grammarPanel = makePanel(margin * 3 + dataBasePanelWidth + mainWordPanelWidth, margin, dataBasePanelWidth,
                dataBasePanelHeight, veryLightGray);
        wordPanel.add(grammarPanel);

        commentPanelWidth = (wordPanelWidth - margin * 4) / 3;
        commentPanelHeight = wordPanelHeight - margin * 3 - mainWordPanelHeight;
        commentPanelLevel = mainWordPanelHeight + margin * 2;
        commentPanel = makePanel(margin, commentPanelLevel, commentPanelWidth,
                commentPanelHeight, veryLightGray);
//        commentPanel.setLayout(null);
        wordPanel.add(commentPanel);

        picturePanel = makePanel(margin * 2 + commentPanelWidth, commentPanelLevel, commentPanelWidth,
                commentPanelHeight, veryLightGray);
//        examplePanel.setLayout(null);
        wordPanel.add(picturePanel);

        tagsPanel = makePanel(margin * 3 + commentPanelWidth * 2, commentPanelLevel, commentPanelWidth,
                commentPanelHeight, veryLightGray);
//        tagsPanel.setLayout(null);
        wordPanel.add(tagsPanel);


        examplePanel = makePanel(margin, margin, commentPanelWidth, userPanelHeight - margin * 2, veryLightGray);
        userPanel.add(examplePanel);

        userActionPanel = makePanel(margin * 2 + commentPanelWidth, margin,
                userPanelWidth - margin * 3 - commentPanelWidth, userPanelHeight - margin * 2, veryLightGray);
        userPanel.add(userActionPanel);

//        ---------------------------------------------------------------------------------------------------------
//        JLabels:
        dbsLabel = makeLabel("Databases:", headerFont, JLabel.LEFT);
        dbsLabel.setBounds(labelMargin, labelMargin, 150, headerFont.getSize());
        optionsPanel.add(dbsLabel);

        feedbackLabel = makeLabel("Correct / Wrong", normalFont, JLabel.CENTER);
        mainWordPanel.add(feedbackLabel);

        wordLabel = makeLabel("Word", wordFont, JLabel.CENTER);
        mainWordPanel.add(wordLabel);

        currentDB_Label = makeLabel("Current data base:", headerFont, JLabel.LEFT);
        currentDB_Label.setBounds(labelMargin, labelMargin, 250, headerFont.getSize() + 5);
        dataBasePanel.add(currentDB_Label);

        int valueObjectLevel = labelMargin * 2 + headerFont.getSize() + 5;

        currDB_ValueLabel = makeLabel("The data base", normalFont, JLabel.LEFT);
        currDB_ValueLabel.setBounds(labelMargin, valueObjectLevel, 250,
                normalFont.getSize() + 5);
        dataBasePanel.add(currDB_ValueLabel);

        posLabel = makeLabel("Part of speech:", headerFont, JLabel.LEFT);
        posLabel.setBounds(labelMargin, labelMargin, 250, headerFont.getSize() + 5);
        grammarPanel.add(posLabel);

        posValueLabel = makeLabel("The part of speech", normalFont, JLabel.LEFT);
        posValueLabel.setBounds(labelMargin, valueObjectLevel, 250,normalFont.getSize() + 5);
        grammarPanel.add(posValueLabel);

        commentLabel = makeLabel("Comment:", headerFont, JLabel.LEFT);
        commentLabel.setBounds(labelMargin, labelMargin, 150, headerFont.getSize() + 5);
        commentPanel.add(commentLabel);

        exampleLabel = makeLabel("Example:", headerFont, JLabel.LEFT);
        exampleLabel.setBounds(labelMargin, labelMargin, 250, headerFont.getSize() + 5);
        examplePanel.add(exampleLabel);

        tagsLabel = makeLabel("Tags:", headerFont, JLabel.LEFT);
        tagsLabel.setBounds(labelMargin, labelMargin, 250, headerFont.getSize() + 5);
        tagsPanel.add(tagsLabel);

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
                if(e.getStateChange() == ItemEvent.SELECTED) {
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
                if(e.getStateChange() == ItemEvent.SELECTED) {
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
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    tagsArea.setVisible(true);
                } else
                    tagsArea.setVisible(false);
            }
        });
        tagsPanel.add(tagsCheckBox);

        pictureCheckBox = new JCheckBox();
        pictureCheckBox.setBounds(commentPanelWidth - 20 - labelMargin, labelMargin, 20, 20);
        pictureCheckBox.setBackground(veryLightGray);
        pictureCheckBox.setMnemonic(KeyEvent.VK_P);
        pictureCheckBox.setSelected(true);
        pictureCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
//                    picture.setVisible(true);
                }
//                else
//                    picture.setVisible(false);
            }
        });
        picturePanel.add(pictureCheckBox);

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

        enterButton = makeButton("Enter", buttonFont, examplePanel.getWidth(), labelMargin,
                (tagsPanel.getWidth() + margin - 3 * labelMargin) / 3, userWordInput.getHeight(), mediumPurple);
        userActionPanel.add(enterButton);

        nextButton = makeButton("Next", buttonFont, enterButton.getX() + enterButton.getWidth() + labelMargin,
                labelMargin, enterButton.getWidth(), userWordInput.getHeight(), mediumPurple);
        userActionPanel.add(nextButton);

        checkButton = makeButton("Check", buttonFont, nextButton.getX() + nextButton.getWidth() + labelMargin,
                labelMargin, enterButton.getWidth(), userWordInput.getHeight(), mediumPurple);
        userActionPanel.add(checkButton);

        hintLabel = makeLabel("This is hint", normalFont, JLabel.LEFT);
        hintLabel.setBounds(labelMargin, userWordInput.getHeight() + 2 * labelMargin, userWordInput.getWidth(),
                userWordInput.getHeight());
        userActionPanel.add(hintLabel);

        hintButton = makeButton("Hint", buttonFont, enterButton.getX(), hintLabel.getY(), enterButton.getWidth(),
                enterButton.getHeight(), mediumPurple);
        userActionPanel.add(hintButton);

        checkLabel = makeLabel("Check answer", normalFont, JLabel.CENTER);
        checkLabel.setBounds(nextButton.getX(), hintLabel.getY(), checkButton.getWidth() * 2 + labelMargin,
                hintLabel.getHeight());
        userActionPanel.add(checkLabel);

        userSuggestionsInput = new JTextArea();
        userSuggestionsInput.setBounds(labelMargin, userActionPanel.getHeight() - 3 * (enterButton.getHeight() + labelMargin),
                nextButton.getX() - 2 * labelMargin,userActionPanel.getHeight() - 200 - labelMargin);
        userSuggestionsInput.setBackground(veryLightGray);
        userSuggestionsInput.setFont(textFont);
        userSuggestionsInput.setForeground(veryDarkGray);
        userSuggestionsInput.setBorder(BorderFactory.createLineBorder(lightGray));
        userActionPanel.add(userSuggestionsInput);

        leaveFeedbackLabel = makeLabel("Leave feedback below:", smallHeaderFont, JLabel.LEFT);
        leaveFeedbackLabel.setBounds(labelMargin, userSuggestionsInput.getY() - hintLabel.getHeight(),
                userSuggestionsInput.getWidth(), hintLabel.getHeight());
        leaveFeedbackLabel.setForeground(veryDarkGray);
        userActionPanel.add(leaveFeedbackLabel);

        isTranslationCorrectLabel = makeLabel("Is translation correct?", smallHeaderFont, JLabel.CENTER);
        isTranslationCorrectLabel.setBounds(nextButton.getX(), leaveFeedbackLabel.getY(),
                nextButton.getWidth() * 2 + labelMargin, leaveFeedbackLabel.getHeight());
        userActionPanel.add(isTranslationCorrectLabel);

        okButton = makeButton("Yes", buttonFont, nextButton.getX(), userSuggestionsInput.getY(),
                nextButton.getWidth(), nextButton.getHeight(), mediumPurple);
        okButton.setBackground(goodColor);
        okButton.addActionListener(main.utilsHandler);
        okButton.setActionCommand("ok");
        userActionPanel.add(okButton);

        nokButton = makeButton("No", buttonFont, checkButton.getX(), userSuggestionsInput.getY(),
                nextButton.getWidth(), nextButton.getHeight(), mediumPurple);
        nokButton.setBackground(badColor);
        nokButton.addActionListener(main.utilsHandler);
        nokButton.setActionCommand("nok");
        userActionPanel.add(nokButton);

        thanksForAnswerLabel = makeLabel("Thank you for your answer", smallHeaderFont, JLabel.CENTER);
        thanksForAnswerLabel.setBounds(okButton.getX(), okButton.getY() + okButton.getHeight() + labelMargin,
                okButton.getWidth() * 2 + labelMargin, okButton.getHeight());
        thanksForAnswerLabel.setVisible(false);
        userActionPanel.add(thanksForAnswerLabel);

        submitButton = makeButton("Submit", buttonFont, okButton.getX(),
                thanksForAnswerLabel.getY() + labelMargin + thanksForAnswerLabel.getHeight(), nextButton.getWidth(),
                nextButton.getHeight(), mediumPurple);
        submitButton.addActionListener(main.utilsHandler);
        submitButton.setActionCommand("submit");
        userActionPanel.add(submitButton);

        isSubmittedLabel = makeLabel("Submitted", smallHeaderFont, JLabel.CENTER);
        isSubmittedLabel.setBounds(nokButton.getX(), submitButton.getY(), nokButton.getWidth(), submitButton.getHeight());
        isSubmittedLabel.setVisible(false);
        userActionPanel.add(isSubmittedLabel);


    }
}
