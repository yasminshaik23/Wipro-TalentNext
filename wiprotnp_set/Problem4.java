import java.util.*;

class Country {
    TreeSet<String> H1 = new TreeSet<>();
    public TreeSet<String> saveCountryNames(String countryName) {
        H1.add(countryName);
        return H1;
    }
    public String getCountry(String countryName) {

        Iterator<String> itr = H1.iterator();

        while (itr.hasNext()) {
            String country = itr.next();

            if (country.equalsIgnoreCase(countryName)) {
                return country;
            }
        }
        return null;
    }
}

public class Problem4 {

    public static void main(String[] args) {
        Country obj = new Country();
        obj.saveCountryNames("India");
        obj.saveCountryNames("USA");
        obj.saveCountryNames("Japan");
        obj.saveCountryNames("Australia");
        obj.saveCountryNames("Canada");
        System.out.println("Countries: " + obj.H1);
        System.out.println("Search India: " + obj.getCountry("India"));
        System.out.println("Search China: " + obj.getCountry("China"));
    }
}