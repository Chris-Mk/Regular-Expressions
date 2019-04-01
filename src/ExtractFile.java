import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();

        String file = path.substring(path.lastIndexOf('\\') + 1);
        String filename = file.substring(0, file.lastIndexOf('.'));
        String extension = file.substring(file.lastIndexOf('.') + 1).trim();

        System.out.println("File name: " + filename);
        System.out.println("File extension: " + extension);
    }
}
