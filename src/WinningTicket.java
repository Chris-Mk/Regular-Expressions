import java.util.Scanner;

public class WinningTicket {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] tickets = scan.nextLine().split("\\s+,\\s+");

        for (String ticket : tickets) {
            if (ticket.length() == 20) {
                StringBuilder firstHalf = new StringBuilder();
                StringBuilder secondHalf = new StringBuilder();

                for (int i = 0; i < ticket.length(); i++) {
                    if (i < ticket.length() / 2) {
                        firstHalf.append(ticket.charAt(i));
                    } else {
                        secondHalf.append(ticket.charAt(i));
                    }
                }

                int firstCount = 0, secondCount = 0, firstSymbol = 0;

                for (int i = 0; i < firstHalf.length(); i++) {
                    if (firstHalf.charAt(i) == '@' || firstHalf.charAt(i) == '#' ||
                            firstHalf.charAt(i) == '$' || firstHalf.charAt(i) == '^') {
                        firstCount++;
                        firstSymbol = firstHalf.charAt(i);
                    }

                    if (secondHalf.charAt(i) == '@' || secondHalf.charAt(i) == '#' ||
                            secondHalf.charAt(i) == '$' || secondHalf.charAt(i) == '^') {
                        secondCount++;
                    }
                }

                if (firstCount >= 6 && firstCount <= 9) {
                    if (firstCount == secondCount) {
                        System.out.println(String.format("ticket \"%s\" - %d%c", ticket, firstCount, (char) firstSymbol));
                    }
                } else if (firstCount == 10 && secondCount == 10){
                    System.out.println(String.format("ticket \"%s\" - %d%c Jackpot!", ticket, firstCount, (char) firstSymbol));
                } else {
                    System.out.println(String.format("ticket \"%s\" - no match", ticket));
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}
