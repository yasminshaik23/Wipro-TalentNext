interface PrimeCheck {
    PrimeNumber create(int n);
}
class PrimeNumber {

    PrimeNumber(int n) {

        boolean prime = true;

        if (n < 2)
            prime = false;
        else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    prime = false;
                    break;
                }
            }
        }

        if (prime)
            System.out.println("Prime");
        else
            System.out.println("Not Prime");
    }
}
public class Problem3 {

    public static void main(String[] args) {
        PrimeCheck p = PrimeNumber::new;

        p.create(17);
        p.create(20);
    }
}