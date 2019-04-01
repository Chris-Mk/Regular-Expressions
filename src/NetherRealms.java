import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] demons = scan.nextLine().split("\\s*,\\s*");

        Map<String, Integer> demonsHealth = new TreeMap<>();
        Map<String, Double> demonsDamage = new TreeMap<>();

        for (String demon : demons) {
            Pattern healthPattern = Pattern.compile("[^\\d\\-*/+.,\\s]");
            Matcher healthMatcher = healthPattern.matcher(demon);
            int health = 0;

            while (healthMatcher.find()) {
                health += healthMatcher.group().charAt(0);
            }

            demonsHealth.put(demon, health);

            Pattern damagePattern = Pattern.compile("[+-]?\\d+(\\.\\d+)?");
            Matcher damageMatcher = damagePattern.matcher(demon);
            double damage = 0d;

            while (damageMatcher.find()) {
                damage += Double.parseDouble(damageMatcher.group());
            }

            for (int i = 0; i < demon.length(); i++) {
                if (demon.charAt(i) == '*') {
                    damage *= 2;
                } else if (demon.charAt(i) == '/') {
                    damage /= 2;
                }
            }

            demonsDamage.put(demon, damage);
        }

        for (var demon : demonsHealth.entrySet()) {
            if (demonsDamage.containsKey(demon.getKey())) {
                System.out.println(String.format("%s - %d health, %.2f damage",
                        demon.getKey(),
                        demon.getValue(),
                        demonsDamage.get(demon.getKey())));
            }
        }
    }
}
