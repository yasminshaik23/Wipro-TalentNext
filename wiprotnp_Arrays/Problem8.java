import java.util.*;

public class Problem8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        boolean ignore = false;

        for (int i = 0; i < n; i++) {

            if (arr[i] == 6) {
                ignore = true;
            }

            if (!ignore) {
                sum += arr[i];
            }

            if (arr[i] == 7 && ignore) {
                ignore = false;
            }
        }

        System.out.println("Sum = " + sum);

        sc.close();
    }
}