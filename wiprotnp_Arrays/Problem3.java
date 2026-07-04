import java.util.*;

public class Problem3 {
    public static void main(String[] args) {

        int[] arr = {1, 4, 34, 56, 7};

        Scanner sc = new Scanner(System.in);
        int search = sc.nextInt();

        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                index = i;
                break;
            }
        }

        System.out.println(index);

        sc.close();
    }
}