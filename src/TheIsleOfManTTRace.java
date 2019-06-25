package TextProcessingAndRegularExprressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleOfManTTRace {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("([#$%&*])([A-Za-z]+)\\1=(\\d+)!!(.*)");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (true) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group(2);
                int length = Integer.parseInt(matcher.group(3));
                String code = matcher.group(4);

                if (length == code.length()) {
                    StringBuilder decrypted = new StringBuilder();

                    for (int i = 0; i < code.length(); i++) {
                        char ch = (char) (code.charAt(i) + length);
                        decrypted.append(ch);
                    }
                    System.out.println(String.format("Coordinates found! %s -> %s", name, decrypted));
                    break;
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }

            input = scan.nextLine();
        }
    }
}
