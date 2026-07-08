import java.util.Scanner;
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String firstTwo = str.substring(0, 2);
        for (int i = 0; i < str.length(); i++) {
            System.out.print(firstTwo);
        }
    }
}