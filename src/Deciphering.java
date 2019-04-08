package TextProcessingAndRegularExprressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String encryptedString = scan.nextLine();
        String[] substrings = scan.nextLine().split(" ");

        Pattern pattern = Pattern.compile("^[d-z{}|#]+$");
        Matcher matcher = pattern.matcher(encryptedString);

        if (matcher.find()) {
            StringBuilder decryptedString = new StringBuilder();

            for (int i = 0; i < encryptedString.length(); i++) {
                char ch = (char) (encryptedString.charAt(i) - 3);
                decryptedString.append(ch);
            }

//            while (decryptedString.indexOf(substrings[0]) != -1) {
//                int index = decryptedString.indexOf(substrings[0]);
//
//                decryptedString.delete(index, index + substrings[0].length());
//                decryptedString.insert(index, substrings[1]);
//            }

            System.out.println(decryptedString.toString().replaceAll(substrings[0], substrings[1]));
        } else {
            System.out.println("This is not the book you are looking for.");
        }
    }
}
