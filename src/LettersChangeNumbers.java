import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersChangeNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] elements = scan.nextLine().split("\\s+");

        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";

        Pattern pattern = Pattern.compile("(?<first>[A-Za-z])(?<number>\\d+)(?<last>[A-Za-z])");
        double sum = 0d;

        for (String element : elements) {
            Matcher matcher = pattern.matcher(element);

            if (matcher.find()) {
                String first = matcher.group("first");
                double number = Double.parseDouble(matcher.group("number"));
                String last = matcher.group("last");
                
                if (uppercase.contains(first)) {
                    number /= uppercase.indexOf(first) + 1;
                }

                if (lowercase.contains(first)) {
                    number *= lowercase.indexOf(first) + 1;
                }

                if (uppercase.contains(last)) {
                    number -= uppercase.indexOf(last) + 1;
                }

                if (lowercase.contains(last)) {
                    number += lowercase.indexOf(last) + 1;
                }

                sum += number;
            }
        }

        System.out.printf("%.2f", sum);
    }
}
