interface DigitCount {
    int count(int n);
}
class NumberUtil {

    public static int digitCount(int n) {

        int count = 0;

        while (n != 0) {
            count++;
            n = n / 10;
        }

        return count;
    }
}
public class Problem2 {

    public static void main(String[] args) {
        DigitCount d = NumberUtil::digitCount;

        System.out.println("Digits = " + d.count(123456));
    }
}