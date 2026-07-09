import java.util.*;
public class Problem2 {
    public static int isOdd(int n) {
        if (n % 2 != 0) {
            return 2;
        } else {
            return 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isOdd(n));
    }
}