import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] morseCode = scan.nextLine().split("\\s+");

        StringBuilder builder = new StringBuilder();

        for (String currentChar : morseCode) {
            switch (currentChar) {
                case "|":
                    builder.append(" ");
                    break;
                case ".-":
                    builder.append("A");
                    break;
                case "-...":
                    builder.append("B");
                    break;
                case "-.-.":
                    builder.append("C");
                    break;
                case "-..":
                    builder.append("D");
                    break;
                case ".":
                    builder.append("E");
                    break;
                case "..-.":
                    builder.append("F");
                    break;
                case "--.":
                    builder.append("G");
                    break;
                case "....":
                    builder.append("H");
                    break;
                case "..":
                    builder.append("I");
                    break;
                case ".---":
                    builder.append("J");
                    break;
                case "-.-":
                    builder.append("K");
                    break;
                case ".-..":
                    builder.append("L");
                    break;
                case "--":
                    builder.append("M");
                    break;
                case "-.":
                    builder.append("N");
                    break;
                case "---":
                    builder.append("O");
                    break;
                case ".--.":
                    builder.append("P");
                    break;
                case "--.-":
                    builder.append("Q");
                    break;
                case ".-.":
                    builder.append("R");
                    break;
                case "...":
                    builder.append("S");
                    break;
                case "-":
                    builder.append("T");
                    break;
                case "..-":
                    builder.append("U");
                    break;
                case "...-":
                    builder.append("V");
                    break;
                case ".--":
                    builder.append("W");
                    break;
                case "-..-":
                    builder.append("X");
                    break;
                case "-.--":
                    builder.append("Y");
                    break;
                case "--..":
                    builder.append("Z");
                    break;
            }
        }

        System.out.println(builder.toString());
    }
}
