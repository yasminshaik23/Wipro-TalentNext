import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input file name");
        String inputFile = sc.nextLine();
        System.out.println("Enter the output file name");
        String outputFile = sc.nextLine();
        try (FileReader fr = new FileReader(inputFile);
             FileWriter fw = new FileWriter(outputFile)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
            }
            System.out.println("File is copied.");
        } catch (IOException e) {
            System.out.println("Error while copying file.");
        }
    }
}