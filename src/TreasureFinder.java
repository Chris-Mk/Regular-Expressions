import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreasureFinder {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] keys = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String encryptedText;

        while (!"find".equals(encryptedText = scan.nextLine())) {
            StringBuilder decryptedText = new StringBuilder();
            int index = 0;

            for (int i = 0; i < encryptedText.length(); i++) {
                decryptedText.append((char) (encryptedText.charAt(i) - keys[index++]));

                if (index == keys.length) {
                    index = 0;
                }
            }

            Pattern pattern = Pattern.compile("&(?<treasure>\\w+)&(?:[^&<]+)?<(?<coordinates>\\w+)>");
            Matcher matcher = pattern.matcher(decryptedText);

            if (matcher.find()) {
                System.out.println("Found " + matcher.group("treasure") + " at " + matcher.group("coordinates"));
            }
        }
    }
}
