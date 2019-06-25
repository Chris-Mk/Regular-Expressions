package TextProcessingAndRegularExprressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] keys = scan.nextLine().split("&");

        List<StringBuilder> activeKeys = new ArrayList<>();

        for (String key : keys) {

            if (validateLength(key)) {
                Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
                Matcher matcher = pattern.matcher(key);

                while (matcher.find()) {
                    StringBuilder builder = new StringBuilder(matcher.group().toUpperCase());

                    if (key.length() == 16) {
                        for (int i = 4; i < builder.length(); i += 5) {
                            builder.insert(i, "-");
                        }
                    } else {
                        for (int i = 5; i < builder.length(); i += 6) {
                            builder.insert(i, "-");
                        }
                    }

                    for (int i = 0; i < builder.length(); i++) {
                        if (Character.isDigit(builder.charAt(i))) {
                            int ch = 9 - Character.getNumericValue(builder.charAt(i));
                            builder.setCharAt(i, (char) (ch + '0'));
                        }
                    }

                    activeKeys.add(builder);
                }
            }
        }

        System.out.println(activeKeys.toString().replaceAll("[\\[\\]]", ""));
    }

    private static boolean validateLength(String key) {
        boolean isValid = false;

        if (key.length() == 16 || key.length() == 25) {
            isValid = true;
        }

        return isValid;
    }
}
