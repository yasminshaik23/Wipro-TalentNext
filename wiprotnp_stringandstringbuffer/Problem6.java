import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        if (s1.length() < s2.length()) {
            System.out.println(s1 + s2 + s1);
        } else {
            System.out.println(s2 + s1 + s2);
        }
    }
}