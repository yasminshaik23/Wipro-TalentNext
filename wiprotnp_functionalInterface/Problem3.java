import java.util.*;
import java.util.function.Predicate;

public class Problem3 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "madam","java","level","radar","hello",
                "refer","abc","noon","world","malayalam"));

        Predicate<String> p = str ->
                str.equals(new StringBuilder(str).reverse().toString());

        list.stream()
                .filter(p)
                .forEach(System.out::println);
    }
}