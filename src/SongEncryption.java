package TextProcessingAndRegularExprressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {

        Pattern namePattern = Pattern.compile("^[A-Z][a-z' ]+$");
        Pattern songPattern = Pattern.compile("^[A-Z ]+$");

        Scanner scan = new Scanner(System.in);
        String command;

        while (!"end".equals(command = scan.nextLine())) {
            String[] data = command.split(":");

            String name = data[0];
            String song = data[1];

            int key = name.length();
            Matcher nameMatch = namePattern.matcher(name);
            Matcher songMatch = songPattern.matcher(song);

            if (nameMatch.find() && songMatch.find()) {
                StringBuilder valid = new StringBuilder();

                for (int i = 0; i < command.length(); i++) {
                    char ch = command.charAt(i);

                    if (ch == '\'' || ch == ' ') {
                        valid.append(ch);
                    } else if (ch == ':'){
                        valid.append('@');
                    } else {
                        for (int j = 0; j < key; j++) {
                            ch++;

                            if (ch > 'z' && Character.isLowerCase(command.charAt(i))) {
                                ch = 'a';
                            }

                            if (ch > 'Z' && Character.isUpperCase(command.charAt(i))) {
                                ch = 'A';
                            }
                        }

                        valid.append(ch);
                    }
                }

                System.out.println(String.format("Successful encryption: %s", valid.toString()));
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
