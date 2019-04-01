import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] banWords = scan.nextLine().split(", ");
        String text = scan.nextLine();

        for (String banWord : banWords) {
            if (text.contains(banWord)) {
                text = text.replaceAll(banWord, String.valueOf(repeatedStr(banWord)));
            }
        }

        System.out.println(text);
    }

    private static StringBuilder repeatedStr(String banWord) {
        StringBuilder res = new StringBuilder();

        res.append("*".repeat(banWord.length()));

        return res;
    }
}
