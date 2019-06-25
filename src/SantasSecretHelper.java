package TextProcessingAndRegularExprressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());

        Pattern pattern = Pattern.compile("@([A-Za-z]+)(?:[^@\\-!:>])*!([GN])!");
        List<String> goodKids = new ArrayList<>();
        String encryptedMessage;

        while (!"end".equals(encryptedMessage = scan.nextLine())) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < encryptedMessage.length(); i++) {
                result.append((char) (encryptedMessage.charAt(i) - key));
            }

            Matcher matcher = pattern.matcher(result.toString());

            if (matcher.find()) {
                String name = matcher.group(1);
                String behaviour = matcher.group(2);

                if (behaviour.equals("G")) {
                    goodKids.add(name);
                }
            }
        }

        for (String goodKid : goodKids) {
            System.out.println(goodKid);
        }
    }
}
