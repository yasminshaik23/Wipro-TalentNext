import java.util.*;
import java.util.function.Function;

public class Problem2 {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(10,20,30,40,50,60,70,80,90,100));

        Function<ArrayList<Integer>, Integer> sum = l -> {
            int s = 0;
            for(int n:l)
                s += n;
            return s;
        };

        System.out.println("Sum = " + sum.apply(list));
    }
}