import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        StringBuilder numbers = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder characters = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                numbers.append(text.charAt(i));
            } else if (Character.isLetter(text.charAt(i))) {
                letters.append(text.charAt(i));
            } else {
                characters.append(text.charAt(i));
            }
        }

        System.out.println(numbers);
        System.out.println(letters);
        System.out.println(characters);
    }
}
