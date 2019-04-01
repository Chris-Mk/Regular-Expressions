import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int strength = 0;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            result.append(input.charAt(i));

            if (input.charAt(i) == '>') {
                strength += Character.getNumericValue(input.charAt(i + 1));
            }

            while (strength > 0) {
                strength--;
                i++;

                if (i + 1 == input.length() || input.charAt(i + 1) == '>') {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
