import java.util.*;
import java.util.function.Consumer;

public class Problem6 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "Java","Python","SQL","HTML","Spring",
                "Oracle","Linux","Git","React","CSS"));

        Consumer<String> c = s ->
                System.out.println(new StringBuilder(s).reverse());

        list.forEach(c);
    }
}