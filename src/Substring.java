import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String key = scan.nextLine();
        String text = scan.nextLine();

        int indexOfKey = text.indexOf(key);

        while (indexOfKey != -1) {
            text = text.substring(0, indexOfKey) + text.substring(indexOfKey +  key.length());

            indexOfKey = text.indexOf(key);
        }

        System.out.println(text);
    }
}
