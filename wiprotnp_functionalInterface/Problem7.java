import java.util.*;
import java.util.function.Consumer;

public class Problem7 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(2,5,8,11,14,19,22,25,30,33));

        Consumer<Integer> c = n -> {
            if(n%2==0)
                System.out.println(n+" Even");
            else
                System.out.println(n+" Odd");
        };

        list.forEach(c);
    }
}