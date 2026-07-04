import java.util.*;

public class Problem6 {
    public static void main(String[] args) {

        int[] arr = {12, 45, 7, 89, 34, 23, 90, 5};

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}