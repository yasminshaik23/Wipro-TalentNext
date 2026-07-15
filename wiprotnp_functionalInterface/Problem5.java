import java.util.*;
import java.util.function.Predicate;

public class Problem5 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(2,4,7,9,15,16,20,25,30,36));

        Predicate<Integer> p = n -> {
            int x = (int)Math.sqrt(n);
            return x*x==n;
        };

        list.stream()
                .filter(p)
                .forEach(System.out::println);
    }
}