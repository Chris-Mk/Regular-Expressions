import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        String content = scan.nextLine();
        String comment = scan.nextLine();

        System.out.printf("<h1>\n %s\n</h1>\n", title);
        System.out.printf("<article>\n %s\n</article>\n", content);

        while (!"end of comments".equals(comment)) {
            System.out.printf("<div>\n %s\n</div>\n", comment);
            comment = scan.nextLine();
        }
    }
}
