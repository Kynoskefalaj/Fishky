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
}
