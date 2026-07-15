import java.util.*;

public class Problem2 {
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

        Collections.reverse(al);

        al.forEach(s -> System.out.println(s));
    }
}