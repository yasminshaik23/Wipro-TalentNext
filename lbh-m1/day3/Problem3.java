import java.util.*;
public class Problem3 {
    public static int lastDigit(int n) {
        if(n>0){
            return n % 10;
        }
        else{
            return -(n) % 10;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(lastDigit(n));
    }
}