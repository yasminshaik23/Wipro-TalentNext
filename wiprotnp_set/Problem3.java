import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Apple");
        ts.add("Mango");
        ts.add("Banana");
        ts.add("Orange");
        ts.add("Grapes");
        System.out.println("TreeSet (Ascending Order):");
        System.out.println(ts);
        System.out.println("\nTreeSet (Descending Order):");
        Iterator<String> desc = ts.descendingIterator();
        while (desc.hasNext()) {
            System.out.println(desc.next());
        }
        System.out.println("\nIterating using Iterator:");
        Iterator<String> itr = ts.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        String search = "Mango";

        if (ts.contains(search)) {
            System.out.println("\n" + search + " is present.");
        } else {
            System.out.println("\n" + search + " is not present.");
        }
    }
}