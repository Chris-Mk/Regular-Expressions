import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        StringBuilder result = new StringBuilder(String.valueOf(input.charAt(0)));
        int index = 0;

        for (int i = 1; i < input.length(); i++) {
            if (result.charAt(index) != input.charAt(i)) {
                result.append(input.charAt(i));
                index++;
            }
        }

        System.out.println(result.toString());
    }
}
