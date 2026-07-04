import java.util.*;

public class Problem7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Array after removing duplicates:");

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count == 0) {
                System.out.print(arr[i] + " ");
            }
        }

        sc.close();
    }
}