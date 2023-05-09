package root;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;

public class Mechanics {

    UI ui;

    int wordsLength = 999;
    ResultSet currentWordSet;
    String engWord, polWord, partOfSpeech, userAnswer, hint;
    String comment, polExample, engExample, tag1, tag2, tag3;
    String wordLengthMsg;
    int hintsUsed, hintsAvailable;

    public Mechanics (UI ui) {
        this.ui = ui;
    }

    public static String randomWord (String tableName, String column, int rollRange) {
        Random random = new Random();
        int randInt = random.nextInt(rollRange);

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
        currentWordSet = randomWordResultSet("words", wordsLength);
    }

    public void setRandomWordLabels() {
        if (currentWordSet != null) {
            try {
                polWord = currentWordSet.getString("pol_word");
                engWord = currentWordSet.getString("eng_word");
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

                ui.wordLabel.setText(polWord);
                ui.posValueLabel.setText(partOfSpeech);
                ui.exampleArea.setText(polExample);
                ui.commentArea.setText(comment);
                ui.tagsArea.setText(tag1 + ", " + tag2 + ", " + tag3);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else
            throw new RuntimeException();
    }

    public void notificationsReset(){
        ui.isSubmittedLabel.setVisible(false);
        ui.thanksForAnswerLabel.setVisible(false);
        hint = null;
        ui.hintLabel.setText("");
    }

    public void hintDiscover(){
        if (hint == null) {
            wordLengthMsg = engWord.length() + " letters: ";
            hint = "";
            hintsUsed = 1;
        } else if (hint.equals("")) {
            hint = engWord.substring(0, 1);
            hintsUsed = 2;
        } else if (engWord.length() > hint.length()) {
            int h = hint.length();
            hint = engWord.substring(0, h + 1);
            hintsUsed += 1;
        }

        ui.hintLabel.setText(wordLengthMsg + hint);
    }

}