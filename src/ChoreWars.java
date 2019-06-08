package TextProcessingAndRegularExprressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoreWars {
    public static void main(String[] args) {

        Pattern dishesPattern = Pattern.compile("<[a-z0-9]+>");
        Pattern housePattern = Pattern.compile("\\[[A-Z0-9]+]");
        Pattern laundryPattern = Pattern.compile("\\{.+}");

        Scanner scan = new Scanner(System.in);
        int dishesTime = 0, houseTime = 0, laundryTime = 0;
        String input;

        while (!"wife is happy".equals(input = scan.nextLine())) {
            Matcher dishesMatch = dishesPattern.matcher(input);
            Matcher houseMatch = housePattern.matcher(input);
            Matcher laundryMatch = laundryPattern.matcher(input);

            if (dishesMatch.find()) {
                String validCommand = dishesMatch.group();
                dishesTime += sum(validCommand);
            }

            if (houseMatch.find()) {
                String validCommand = houseMatch.group();
                houseTime += sum(validCommand);
            }

            if (laundryMatch.find()) {
                String validCommand = laundryMatch.group();
                laundryTime += sum(validCommand);
            }
        }

        System.out.printf("Doing the dishes - %d min.\n" +
                "Cleaning the house - %d min.\n" +
                "Doing the laundry - %d min.\n" +
                "Total - %d min.",
                dishesTime, houseTime, laundryTime,
                dishesTime + houseTime + laundryTime);
    }

    private static int sum(String validCommand) {
        int sum = 0;

        for (int i = 0; i < validCommand.length(); i++) {
            if (Character.isDigit(validCommand.charAt(i))) {
                sum += Character.getNumericValue(validCommand.charAt(i));
            }
        }
        return sum;
    }
}
