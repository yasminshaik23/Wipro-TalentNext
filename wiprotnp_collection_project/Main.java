import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TreeMap<Character, Card> cards = new TreeMap<>();

        int count = 0;

        while (cards.size() < 4) {

            System.out.println("Enter a card :");
            char symbol = sc.next().charAt(0);
            int number = sc.nextInt();

            count++;
            if (!cards.containsKey(symbol)) {
                cards.put(symbol, new Card(symbol, number));
            }
        }

        System.out.println("Four symbols gathered in " + count + " cards.");

        System.out.println("Cards in Set are :");

        for (Card c : cards.values()) {
            System.out.println(c.getSymbol() + " " + c.getNumber());
        }
    }
}