import java.util.ArrayList;

public class StringOp {

    public static ArrayList<String> performOperations(String s1, String s2) {

        ArrayList<String> result = new ArrayList<>();

        StringBuilder op1 = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                op1.append(s2);
            } else {
                op1.append(s1.charAt(i));
            }
        }
        result.add(op1.toString());

        int first = s1.indexOf(s2);
        int last = s1.lastIndexOf(s2);

        if (first != -1 && first != last) {
            String rev = new StringBuilder(s2).reverse().toString();
            String op2 = s1.substring(0, last) + rev
                    + s1.substring(last + s2.length());
            result.add(op2);
        } else {
            result.add(s1 + s2);
        }

        if (first != -1 && first != last) {
            String op3 = s1.substring(0, first)
                    + s1.substring(first + s2.length());
            result.add(op3);
        } else {
            result.add(s1);
        }

        int split = (s2.length() + 1) / 2;
        String firstHalf = s2.substring(0, split);
        String secondHalf = s2.substring(split);

        result.add(firstHalf + s1 + secondHalf);

        StringBuilder op5 = new StringBuilder();

        for (char ch : s1.toCharArray()) {
            if (s2.indexOf(ch) != -1) {
                op5.append('*');
            } else {
                op5.append(ch);
            }
        }

        result.add(op5.toString());

        return result;
    }

    public static void main(String[] args) {

        String s1 = "JAVAJAVA";
        String s2 = "VA";

        ArrayList<String> output = performOperations(s1, s2);

        System.out.println("Output:");
        for (String str : output) {
            System.out.println(str);
        }
    }
}