import java.util.*;

public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreeMap<Character, ArrayList<Card1>> map = new TreeMap<>();

        System.out.println("Enter Number of Cards :");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("Enter card " + i + ":");
            char symbol = sc.next().charAt(0);
            int number = sc.nextInt();

            Card1 card = new Card1(symbol, number);

            if (!map.containsKey(symbol)) {
                map.put(symbol, new ArrayList<Card1>());
            }

            map.get(symbol).add(card);
        }

        System.out.println("Distinct Symbols are :");

        for (char ch : map.keySet()) {
            System.out.print(ch + " ");
        }

        System.out.println();

        for (char ch : map.keySet()) {

            ArrayList<Card1> list = map.get(ch);

            System.out.println("Cards in " + ch + " Symbol");

            int sum = 0;

            for (Card1 c : list) {
                System.out.println(c.getSymbol() + " " + c.getNumber());
                sum += c.getNumber();
            }

            System.out.println("Number of cards : " + list.size());
            System.out.println("Sum of Numbers : " + sum);
        }

        sc.close();
    }
}