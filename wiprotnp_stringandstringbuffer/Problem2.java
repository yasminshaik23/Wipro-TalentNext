import java.util.*;
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        char last = s1.charAt(s1.length() - 1);
        char first = s2.charAt(0);
        if (last == first) {
            System.out.println((s1 + s2.substring(1)).toLowerCase());
        } else {
            System.out.println((s1 + s2).toLowerCase());
        }
    }
}