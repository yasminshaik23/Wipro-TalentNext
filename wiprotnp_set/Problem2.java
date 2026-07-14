import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        HashSet<String> employees = new HashSet<>();
        employees.add("Rahul");
        employees.add("Priya");
        employees.add("Amit");
        employees.add("Sneha");
        employees.add("Kiran");
        System.out.println("Employee Names:");
        Iterator<String> itr = employees.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}