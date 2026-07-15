import java.util.*;

class Student {

    int rollNo;
    String name;
    int mark;

    Student(int rollNo, String name, int mark) {
        this.rollNo = rollNo;
        this.name = name;
        this.mark = mark;
    }
}

public class Problem3 {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student(1, "Rahul", 80));
        list.add(new Student(2, "Priya", 45));
        list.add(new Student(3, "Amit", 60));
        list.add(new Student(4, "Sneha", 30));
        list.add(new Student(5, "Kiran", 70));

        long count = list.stream()
                .filter(s -> s.mark >= 50)
                .count();

        System.out.println("Students Passed = " + count);
    }
}