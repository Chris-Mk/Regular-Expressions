import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String decryption = scan.nextLine();
        StringBuilder encryption = new StringBuilder();

        for (int i = 0; i < decryption.length(); i++) {
            char temp = (char) (decryption.charAt(i) + 3);
            encryption.append(temp);
        }

        System.out.println(encryption);
    }
}
