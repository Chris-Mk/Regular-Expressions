package TextProcessingAndRegularExprressions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalSanctuary {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int totalWeight = 0;

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Pattern pattern = Pattern.compile("^n:([^;]*);t:([^;]*);c--([A-Za-z\\s]+)$");
            Matcher matcher =  pattern.matcher(input);

            if (matcher.find()) {
                String encryptedName = matcher.group(1);
                String encryptedKind = matcher.group(2);
                String country = matcher.group(3);

                totalWeight += (int) decryptWord(encryptedName).get(1)
                        + (int) decryptWord(encryptedKind).get(1);

                System.out.println(String.format("%s is a %s from %s",
                        decryptWord(encryptedName).get(0),
                        decryptWord(encryptedKind).get(0),
                        country));
            }
        }
        System.out.println(String.format("Total weight of animals: %dKG", totalWeight));
    }

    private static List<Object> decryptWord(String encryptedName) {
        StringBuilder decryptedName = new StringBuilder();
        int weight = 0;

        for (int i = 0; i < encryptedName.length(); i++) {
            if (Character.isLetter(encryptedName.charAt(i)) || encryptedName.charAt(i) == ' ') {
                decryptedName.append(encryptedName.charAt(i));
            } else if (Character.isDigit(encryptedName.charAt(i))) {
                weight += Character.getNumericValue(encryptedName.charAt(i));
            }
        }
        return Arrays.asList(decryptedName, weight);
    }
}
