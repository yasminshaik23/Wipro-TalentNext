import java.util.*;
public class Problem2 {
    public static void main(String[] args) {
        StringJoiner s1 = new StringJoiner("-");
        s1.add("A");
        s1.add("B");
        s1.add("C");
        StringJoiner s2 = new StringJoiner("-");
        s2.add("X");
        s2.add("Y");
        s2.add("Z");
        StringJoiner t1 = new StringJoiner("-");
        t1.add("X");
        t1.add("Y");
        t1.add("Z");
        t1.merge(s1);
        System.out.println("s1 merged to s2 : " + t1);
        StringJoiner t2 = new StringJoiner("-");
        t2.add("A");
        t2.add("B");
        t2.add("C");
        t2.merge(s2);
        System.out.println("s2 merged to s1 : " + t2);
    }
}