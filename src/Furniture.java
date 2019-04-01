import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String items = scan.nextLine();
        String regex = ">>(?<product>[A-Za-z]+)<<(?<price>[0-9]+\\.*[0-9]+)!(?<amount>[0-9]+)";

        Pattern pattern = Pattern.compile(regex);
        List<String> boughtItems = new ArrayList<>();
        double totalCost = 0d;

        while (!"Purchase".equals(items)) {
            Matcher matcher = pattern.matcher(items);

            if (matcher.find()) {
                boughtItems.add(matcher.group("product"));
                String cost = matcher.group("price");
                String quantity = matcher.group("amount");

                totalCost += Double.parseDouble(cost) * Double.parseDouble(quantity);
            }

            items = scan.nextLine();
        }

        System.out.println("Bought furniture:");
        for (String item : boughtItems) {
            System.out.println(item);
        }

        System.out.printf("Total money spend: %.2f\n", totalCost);
    }
}
