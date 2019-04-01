import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();

            Pattern namePattern = Pattern.compile("@(?<name>\\w+)\\|");
            Matcher nameMatcher = namePattern.matcher(text);

            boolean foundName = false;
            if (nameMatcher.find()) {
                foundName = true;
            }

            Pattern agePattern = Pattern.compile("#(?<age>\\d+)\\*");
            Matcher ageMatcher = agePattern.matcher(text);

            boolean foundAge = false;
            if (ageMatcher.find()) {
                foundAge = true;
            }

            if (foundName && foundAge) {
                System.out.printf("%s is %s years old.\n", nameMatcher.group("name"), ageMatcher.group("age"));
            }
        }
    }
}
