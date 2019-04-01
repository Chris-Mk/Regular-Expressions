import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String firstNum = scan.nextLine();
        int secondNum = Integer.parseInt(scan.nextLine());

        int decimalPart, lastDigit;
        int previousDecimalPart = 0;
        StringBuilder result = new StringBuilder();

        for (int i = firstNum.length() - 1; i >= 0; i--) {
            int currentResult = Character.getNumericValue(firstNum.charAt(i)) * secondNum;

            decimalPart = currentResult / 10;
            lastDigit = currentResult % 10 + previousDecimalPart;

            if (lastDigit <= 9) {
                result.append(lastDigit);
            } else {
                result.append(lastDigit % 10);
                decimalPart++;
            }

            previousDecimalPart = decimalPart;

            if (i == 0 && decimalPart != 0) {
                result.append(decimalPart);
            }
        }

        if (firstNum.equals("0") || secondNum == 0) {
            System.out.println(0);
        } else {
            System.out.println(result.reverse());
        }
    }
}
