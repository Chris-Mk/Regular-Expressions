import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        char firstChar = scan.nextLine().charAt(0);
        char lastChar = scan.nextLine().charAt(0);
        String randomChars = scan.nextLine();

        int sum = 0;

        for (int i = 0; i < randomChars.length(); i++) {
            if (randomChars.charAt(i) > firstChar && randomChars.charAt(i) < lastChar) {
                sum += randomChars.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
