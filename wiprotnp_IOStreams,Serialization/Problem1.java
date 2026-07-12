import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file name");
        String fileName = sc.nextLine();
        System.out.print("Enter the character to be counted ");
        char target = Character.toLowerCase(sc.next().charAt(0));
        int count = 0;
        try (FileReader fr = new FileReader(fileName)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                if (Character.toLowerCase((char) ch) == target) {
                    count++;
                }
            }
            System.out.println("File '" + fileName + "' has " + count +
                               " instances of letter '" + target + "'.");
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
} 
