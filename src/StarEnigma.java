import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {

        String star = "[star]";
        String regex = "@(?<planet>[A-Za-z]+)(?:[^!>@:\\-]*)" +
                ":(?<population>\\d+)(?:[^!>@:\\-]*)" +
                "!(?<attackType>[AD])!(?:[^!>@:\\-]*)" +
                "->(?<soldiers>\\d+)";

        Pattern pattern = Pattern.compile(regex);
        Pattern starPattern = Pattern.compile(star, Pattern.CASE_INSENSITIVE);

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<String> attackedPlanets = new LinkedList<>();
        List<String> destroyedPlanets = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String encryptedMessage = scan.nextLine();
            Matcher starMatch = starPattern.matcher(encryptedMessage);

            int starCount = 0;
            while (starMatch.find()) {
                starCount++;
            }

            StringBuilder decryptedMessage = new StringBuilder();
            for (int j = 0; j < encryptedMessage.length(); j++) {
                char ch = (char) (encryptedMessage.charAt(j) - starCount);
                decryptedMessage.append(ch);
            }

            Matcher matcher = pattern.matcher(decryptedMessage.toString());

            if (matcher.find()) {
                String attackType = matcher.group("attackType");

                if (attackType.equals("A")) {
                    attackedPlanets.add(matcher.group("planet"));
                } else if (attackType.equals("D")) {
                    destroyedPlanets.add(matcher.group("planet"));
                }
            }
        }

        System.out.println("Attacked planets: " + attackedPlanets.size());
        attackedPlanets.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(e -> System.out.println("-> " + e));

        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        destroyedPlanets.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(e -> System.out.println("-> " + e));
    }
}
