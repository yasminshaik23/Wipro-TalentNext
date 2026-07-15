interface Factorial {
    int findFactorial(int n);
}
class MathOperation {

    public int factorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        return fact;
    }
}
public class Problem1 {

    public static void main(String[] args) {

        MathOperation obj = new MathOperation();

        Factorial f = obj::factorial;

        System.out.println("Factorial = " + f.findFactorial(5));
    }
}