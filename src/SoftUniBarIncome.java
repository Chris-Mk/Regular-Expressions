import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String regex = "%(?<customer>[A-Z][a-z]+)%(?:[^|$%.]*?)" +
                "<(?<product>\\w+)>(?:[^|$%.]*?)" +
                "\\|(?<count>[\\d]+)\\|(?:[^|$%.]*?)" +
                "(?<price>[\\d.]+)(?=\\$)";

        Pattern pattern = Pattern.compile(regex);
        double totalIncome = 0;

        String input;
        while (!"end of shift".equals(input = scan.nextLine())) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String count = matcher.group("count");
                String price = matcher.group("price");

                double income = Double.parseDouble(count) * Double.parseDouble(price);
                totalIncome += income;

                System.out.println(String.format("%s: %s - %.2f",
                        matcher.group("customer"),
                        matcher.group("product"),
                        income));
            }
        }

        System.out.println(String.format("Total income: %.2f", totalIncome));
    }
}
