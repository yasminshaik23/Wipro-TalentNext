import java.util.*;

public class Problem1 {
    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 25; i++) {
            al.add(r.nextInt(100) + 1);
        }

        System.out.println("Numbers:");
        System.out.println(al);

        System.out.println("Prime Numbers:");

        al.forEach(n -> {
            if (isPrime(n))
                System.out.print(n + " ");
        });
    }

    static boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}