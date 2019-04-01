import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String regex = "(?<=\\s)[a-z0-9]+[-._]?[a-z0-9]+@[\\w-]+(\\.[\\w-]+)+";
        String input = scan.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
