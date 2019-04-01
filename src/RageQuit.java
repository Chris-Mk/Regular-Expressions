import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        Pattern pattern = Pattern.compile("(?<char>[^\\d]+)(?<num>\\d+)");
        Matcher matcher = pattern.matcher(text);

        List<Character> codes = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        while (matcher.find()) {
            String chars = matcher.group("char").toLowerCase();
            int times = Integer.parseInt(matcher.group("num"));

            builder.append(chars.toUpperCase().repeat(Math.max(0, times)));

            for (int i = 0; i < chars.length(); i++) {
                if (!codes.contains(chars.charAt(i))) {
                    codes.add(chars.charAt(i));
                }
            }
        }

        System.out.println("Unique symbols used: " + codes.size());
        System.out.println(builder.toString());
    }
}
