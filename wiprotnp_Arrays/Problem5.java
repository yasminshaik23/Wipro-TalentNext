import java.util.*;

public class Problem5 {
    public static void main(String[] args) {

        int[] arr = {12, 45, 7, 89, 34, 23, 90, 5};

        Arrays.sort(arr);

        System.out.println("Smallest Number = " + arr[0]);
        System.out.println("Second Smallest Number = " + arr[1]);

        System.out.println("Second Largest Number = " + arr[arr.length - 2]);
        System.out.println("Largest Number = " + arr[arr.length - 1]);
    }
}