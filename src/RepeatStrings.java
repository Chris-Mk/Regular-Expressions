import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] inputArray = scan.nextLine().split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String el : inputArray) {
            result.append(el.repeat(el.length()));
        }

        System.out.println(result);
    }
}
