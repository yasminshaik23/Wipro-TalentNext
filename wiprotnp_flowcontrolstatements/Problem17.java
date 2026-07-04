public class Problem17 {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please enter a number");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int original = n;
        int reverse = 0;

        while (n > 0) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n = n / 10;
        }

        if (original == reverse) {
            System.out.println(original + " is a palindrome");
        } else {
            System.out.println(original + " is not a palindrome");
        }
    }
}