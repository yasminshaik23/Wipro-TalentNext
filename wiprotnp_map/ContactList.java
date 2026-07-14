import java.util.*;

public class ContactList {
    public static void main(String[] args) {

        HashMap<String, Integer> contacts = new HashMap<>();

        contacts.put("Rahul", 12345);
        contacts.put("Priya", 23456);
        contacts.put("Amit", 34567);
        contacts.put("Sneha", 45678);
        contacts.put("Kiran", 56789);

        System.out.println("Contact List:");
        System.out.println(contacts);

        String name = "Rahul";
        if (contacts.containsKey(name)) {
            System.out.println("\nContact \"" + name + "\" exists.");
        } else {
            System.out.println("\nContact \"" + name + "\" does not exist.");
        }

  
        int phone = 34567;
        if (contacts.containsValue(phone)) {
            System.out.println("Phone Number " + phone + " exists.");
        } else {
            System.out.println("Phone Number " + phone + " does not exist.");
        }

        System.out.println("\nContact Details:");

        Iterator<Map.Entry<String, Integer>> itr =
                contacts.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            System.out.println("Name: " + entry.getKey()
                    + ", Phone: " + entry.getValue());
        }
    }
}