import java.util.Scanner;
public class Problem9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String result = "";
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
            result = result + s1.charAt(i) + s2.charAt(i);
        }
        result = result + s1.substring(min) + s2.substring(min);
        System.out.println(result);
    }
}