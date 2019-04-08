package TextProcessingAndRegularExprressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\|");

        String firstPart = input[0];
        String secondPart = input[1];
        String thirdPart = input[2];

        Pattern firstPattern = Pattern.compile("([$#%*&])([A-Z]+)\\1");
        Pattern secondPattern = Pattern.compile("([0-9]{2}):([0-9]{2})");

        Matcher firstMatch = firstPattern.matcher(firstPart);
        Matcher secondMatch = secondPattern.matcher(secondPart);

        if (firstMatch.find()) {
            String startLetters = firstMatch.group(2);

            for (int i = 0; i < startLetters.length(); i++) {
                char ch = startLetters.charAt(i);

                while (secondMatch.find()) {
                    int charCode = Integer.parseInt(secondMatch.group(1));

                    if (ch == charCode) {
                        int wordLength = Integer.parseInt(secondMatch.group(2));
                        String[] texts = thirdPart.split(" ");

                        for (String text : texts) {
                            if (text.startsWith(String.valueOf(ch)) && text.length() == wordLength + 1) {
                                System.out.println(text);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
