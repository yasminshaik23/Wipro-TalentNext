import java.util.*;
public class Problem4 {
    public static int secondLastDigit(int n) {
        n = Math.abs(n);
        if (n < 10) {
            return -1;
        }
        return (n / 10) % 10;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(secondLastDigit(n));
    }
}