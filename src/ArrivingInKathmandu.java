package TextProcessingAndRegularExprressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^(?<peak>[\\w!@#$?]+)=(?<length>[\\d]+)<<(?<code>.*)");

        String encryptedMessage;
        while (!"Last note".equals(encryptedMessage = scan.nextLine())) {
            Matcher matcher = pattern.matcher(encryptedMessage);

            if (matcher.find()) {
                String name = matcher.group("peak");
                int length = Integer.parseInt(matcher.group("length"));
                String code = matcher.group("code");

                if (length == code.length()) {
                    StringBuilder peak = new StringBuilder();

                    for (int i = 0; i < name.length(); i++) {
                        if (Character.isLetterOrDigit(name.charAt(i))) {
                            peak.append(name.charAt(i));
                        }
                    }

                    System.out.println(String.format("Coordinates found! %s -> %s", peak, code));
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }
        }
    }
}