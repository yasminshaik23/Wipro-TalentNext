import java.util.*;

public class Problem3 {
    public static void printAll(ArrayList<String> list) {
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("SQL");
        list.add("HTML");
        System.out.println("Elements in the ArrayList:");
        printAll(list);
    }
}