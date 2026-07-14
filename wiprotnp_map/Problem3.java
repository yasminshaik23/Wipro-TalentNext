import java.util.*;

public class Problem3 {
    public static void main(String[] args) {

        Properties p = new Properties();

        p.setProperty("Andhra Pradesh", "Amaravati");
        p.setProperty("Telangana", "Hyderabad");
        p.setProperty("Karnataka", "Bengaluru");
        p.setProperty("Tamil Nadu", "Chennai");
        p.setProperty("Maharashtra", "Mumbai");

        System.out.println("States and their Capitals:");

        Iterator<Object> itr = p.keySet().iterator();

        while (itr.hasNext()) {
            String state = (String) itr.next();
            System.out.println(state + " -> " + p.getProperty(state));
        }
    }
}