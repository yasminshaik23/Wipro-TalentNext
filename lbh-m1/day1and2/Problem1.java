import java.util.*;
public class Problem1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 0){
            System.out.println( "negative number");
        }
        else if(n > 0){
            System.out.println("postive number");
        }
        else{
            System.out.println( "Zero");
        }
    }
}