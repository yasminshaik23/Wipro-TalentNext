interface WordCount {
    int count(String str);
}
public class MyClassWithLambda {

    public static void main(String[] args) {

        WordCount wc = (str) -> {

            if (str.trim().isEmpty())
                return 0;

            return str.trim().split("\\s+").length;
        };

        String s = "Java is an object oriented programming language";

        System.out.println("Sentence:");
        System.out.println(s);

        System.out.println("Number of Words = " + wc.count(s));
    }
}