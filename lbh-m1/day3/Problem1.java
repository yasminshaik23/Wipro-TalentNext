import java.util.*;
public class Problem1 {
    public static int isEven(int n) {
        if (n % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isEven(n));
    }
}