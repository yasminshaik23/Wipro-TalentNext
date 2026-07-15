import java.util.*;

public class Problem3 {
    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<>();

        al.add("Java");
        al.add("Python");
        al.add("HTML");
        al.add("CSS");
        al.add("SQL");
        al.add("React");
        al.add("Spring");
        al.add("Oracle");
        al.add("Linux");
        al.add("Git");

        System.out.println("Strings with Odd Length:");

        al.forEach(str -> {
            if (str.length() % 2 != 0)
                System.out.println(str);
        });
    }
}