import java.util.Scanner;
public class Problem8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int index = str.indexOf('*');
        String result = str.substring(0, index - 1)
                       + str.substring(index + 2);

        System.out.println(result);
    }
}