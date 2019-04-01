import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        while (!text.equals("end")) {
            StringBuilder builder = new StringBuilder(text);
            builder.reverse();

            System.out.println(text + " = " + builder);
            text = scan.nextLine();
        }
    }
}
