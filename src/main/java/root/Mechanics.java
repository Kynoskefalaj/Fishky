package root;

import root.UserInterface.UI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;

public class Mechanics {

    UI ui;

    int wordsQty = 999;
    ResultSet currentWordSet;
    String engWord, polWord, partOfSpeech, userAnswer, hint;
    String comment, polExample, engExample, tag1, tag2, tag3;
    String wordLengthMsg;
    int hintsUsed, hintsAvailable;

    public Mechanics (UI ui) {
        this.ui = ui;
    }

    public static String randomWord (String tableName, String column, int wordsQty) {
        Random random = new Random();
        int randInt = random.nextInt(wordsQty);

        String sqlRequest = "SELECT * FROM " + tableName + " WHERE id = " + randInt;
        try {
            ResultSet result = QueryExecutor.executeSelect(sqlRequest);
            result.next();
            return result.getString(column);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static int totalSetRecordsQty() {
        String sqlRequest = "SELECT COUNT(\"word_id\") AS wordsQty FROM words";
        try {
            ResultSet result = QueryExecutor.executeSelect(sqlRequest);
            result.next();
            return result.getInt("wordsQty");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    public static ResultSet randomWordResultSet (String tableName, int rollRange) {
        Random random = new Random();
        int randInt = random.nextInt(rollRange);

        String sqlQuery = "SELECT * FROM " + tableName + " WHERE id = " + randInt;
        try {
            ResultSet result = QueryExecutor.executeSelect(sqlQuery);
            result.next();
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet getFrequencyFields (ResultSet rolledWordResultSet) {
        try {
            String word_id = rolledWordResultSet.getString("id");
            String sqlQuery = "SELECT * FROM frequency WHERE word_id = " + word_id;

            ResultSet result = QueryExecutor.executeSelect(sqlQuery);
            result.next();
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet getExplanationFields (ResultSet rolledWordResultSet) {
        try {
            String word_id = rolledWordResultSet.getString("id");
            String sqlQuery = "SELECT * FROM explanation WHERE word_id = " + word_id;

            ResultSet result = QueryExecutor.executeSelect(sqlQuery);
            result.next();
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet getTagsFields (ResultSet rolledWordResultSet) {
        try {
            String word_id = rolledWordResultSet.getString("id");
            String sqlQuery = "SELECT * FROM tags WHERE word_id = " + word_id;

            ResultSet result = QueryExecutor.executeSelect(sqlQuery);
            result.next();
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    public void generateRandomWordResultSet(){
        currentWordSet = randomWordResultSet("words", wordsQty);
    }

    public void setRandomWordLabels(){
        if (currentWordSet != null) {
            try {
                polWord = currentWordSet.getString("pol_word");
                engWord = currentWordSet.getString("eng_word");
                ui.hiddenWordLabel.setText(engWord);
                partOfSpeech = currentWordSet.getString("part_of_speech");
                polExample = Objects.requireNonNull(getExplanationFields(currentWordSet))
                        .getString("pol_phrase");
                engExample = Objects.requireNonNull(getExplanationFields(currentWordSet))
                        .getString("eng_phrase") + "\n\n" +
                        Objects.requireNonNull(getExplanationFields(currentWordSet))
                        .getString("eng_sentence");
                comment = Objects.requireNonNull(getExplanationFields(currentWordSet))
                        .getString("eng_explanation");
                tag1 = Objects.requireNonNull(getTagsFields(currentWordSet))
                        .getString("tag_1");
                tag2 = Objects.requireNonNull(getTagsFields(currentWordSet))
                        .getString("tag_2");
                tag3 = Objects.requireNonNull(getTagsFields(currentWordSet))
                        .getString("tag_3");

                ui.wordLabel.setText(Utilities.customLineWrap(polWord));
                ui.posValueLabel.setText(partOfSpeech);
                ui.exampleArea.setText(polExample);
                ui.commentArea.setText(comment);
                ui.tagsArea.setText(tag1 + ", " + tag2 + ", " + tag3);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public void notificationsReset(){
        ui.isSubmittedLabel.setVisible(false);
        ui.thanksForAnswerLabel.setVisible(false);
        hint = null;
        userAnswer = null;
        ui.hintLabel.setText("");
        ui.feedbackLabel.setText("");
        ui.userWordInput.setText("");
        ui.hiddenWordLabel.setVisible(false);
    }

    public void hintDiscover(){
        if (hint == null) {
            hintToAsterisks();
            hintsUsed = 1;
        } else if (hintsUsed < engWord.length() + 1) {
            charRevealFromAsterisks(hintsUsed - 1);
            if (engWord.charAt(hintsUsed - 1) != ' ') {
                hintsUsed += 1;
            }
        }
        ui.hintLabel.setText(hint);
    }

    public void hintToAsterisks(){
        hint = "";
        for (int i = 0; i < engWord.length(); i++){
            if (engWord.charAt(i) != ' '){
                hint += "*";
            } else hint += " ";
        }
    }

    public void charRevealFromAsterisks(int index){
        char[] tempHint = hint.toCharArray();
        tempHint[index] = engWord.charAt(index);
        hint = new String(tempHint);
    }

    public void checkAnswer(){
        //get user input and set field - userAnswer
        userAnswer = ui.userWordInput.getText();
        //checks if userAnswer is correct and set field correctAnswer as boolean

        if (Objects.equals(userAnswer.toLowerCase(), engWord.toLowerCase())){
            ui.setFeedback(true);
        } else ui.setFeedback(false);
    }

}