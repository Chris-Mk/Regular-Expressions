import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        String firstStr = text.substring(0, text.indexOf(' '));
        String secondStr = text.substring(text.lastIndexOf(' ') + 1);

        System.out.println(multiplyCharacters(firstStr, secondStr));
    }

    private static int multiplyCharacters(String first, String second) {
        int minLength = Math.min(first.length(), second.length());
        int sum = 0;

        for (int i = 0; i < minLength; i++) {
            sum += first.charAt(i) * second.charAt(i);
        }

        String maxLength = first.length() > second.length() ? first : second;

        for (int i = minLength; i < maxLength.length(); i++) {
            sum += maxLength.charAt(i);
        }

        return sum;
    }
}
