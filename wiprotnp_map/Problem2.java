import java.util.*;

public class Problem2 {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();

        map.put("India", "Delhi");
        map.put("Japan", "Tokyo");
        map.put("USA", "Washington");
        map.put("Australia", "Canberra");
        System.out.println("HashMap:");
        System.out.println(map);
        String key = "India";

        if (map.containsKey(key)) {
            System.out.println("\nKey \"" + key + "\" exists.");
        } else {
            System.out.println("\nKey \"" + key + "\" does not exist.");
        }
        String value = "Tokyo";

        if (map.containsValue(value)) {
            System.out.println("Value \"" + value + "\" exists.");
        } else {
            System.out.println("Value \"" + value + "\" does not exist.");
        }
        System.out.println("\nIterating through HashMap:");

        Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<String, String> entry = itr.next();
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}