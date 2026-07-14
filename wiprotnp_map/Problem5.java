import java.util.*;

class CountryMap {

    TreeMap<String, String> M1 = new TreeMap<>();

    public TreeMap<String, String> saveCountryCapital(String countryName, String capital) {
        M1.put(countryName, capital);
        return M1;
    }

    public String getCapital(String countryName) {
        return M1.get(countryName);
    }

    public String getCountry(String capitalName) {

        for (Map.Entry<String, String> entry : M1.entrySet()) {

            if (entry.getValue().equalsIgnoreCase(capitalName)) {
                return entry.getKey();
            }
        }

        return null;
    }

    public TreeMap<String, String> swapKeyValue() {

        TreeMap<String, String> M2 = new TreeMap<>();

        for (Map.Entry<String, String> entry : M1.entrySet()) {
            M2.put(entry.getValue(), entry.getKey());
        }

        return M2;
    }

    public ArrayList<String> getCountryList() {

        ArrayList<String> list = new ArrayList<>();

        for (String country : M1.keySet()) {
            list.add(country);
        }

        return list;
    }
}

public class Problem5 {

    public static void main(String[] args) {

        CountryMap obj = new CountryMap();
        obj.saveCountryCapital("India", "Delhi");
        obj.saveCountryCapital("Japan", "Tokyo");
        obj.saveCountryCapital("USA", "Washington");
        obj.saveCountryCapital("Australia", "Canberra");

        System.out.println("Country -> Capital");
        System.out.println(obj.M1);
        System.out.println("\nCapital of India: "
                + obj.getCapital("India"));
        System.out.println("Country of Tokyo: "
                + obj.getCountry("Tokyo"));
        System.out.println("\nCapital -> Country");
        System.out.println(obj.swapKeyValue());
        System.out.println("\nCountry List");
        System.out.println(obj.getCountryList());
    }
}