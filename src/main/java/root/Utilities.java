package root;

public class Utilities {

    public static String customLineWrap(String str) {
        String outputStr = "<html><center>";
        boolean lastCharWasSpecial = false;
        int thresholdLength = 8;
        int currentLineLength = 0;

        for (int i = 0; i < str.length(); i++){

            if (str.charAt(i) == ' '){
                if (lastCharWasSpecial == false){
                    if (currentLineLength < thresholdLength){
                        outputStr += ' ';
                        lastCharWasSpecial = false;
                        currentLineLength += 1;
                    } else {
                        outputStr += "<br>";
                        lastCharWasSpecial = true;
                        currentLineLength = 0;
                    }
                }
            } else if (str.charAt(i) == '/'){
                if (currentLineLength < thresholdLength){
                  outputStr += ", ";
                  lastCharWasSpecial = true;
                  currentLineLength += 2;
                } else{
                    outputStr += ",<br>";
                    lastCharWasSpecial = true;
                    currentLineLength = 0;
                }
            } else {
                outputStr += str.charAt(i);
                lastCharWasSpecial = false;
                currentLineLength += 1;
            }
        }
        outputStr += "</center></html>";
        return outputStr;
    }

    public static String integerToRomanNumber(int input) {
        if (input < 1 || input > 3999)
            return "Invalid Roman Number Value";
        String s = "";
        while (input >= 1000) {
            s += "M";
            input -= 1000;        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }
}
