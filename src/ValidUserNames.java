import java.util.Scanner;

public class ValidUserNames {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split(", ");

        for (String name : names) {
            if (validateName(name)) {
                System.out.println(name);
            }
        }
    }

    private static boolean validateName(String name) {
        if (name.length() < 3 || name.length() > 16) {
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetterOrDigit(name.charAt(i))
                    && name.charAt(i) != '-'
                    && name.charAt(i) != '_') {
                return false;
            }
        }

        return true;
    }
}
