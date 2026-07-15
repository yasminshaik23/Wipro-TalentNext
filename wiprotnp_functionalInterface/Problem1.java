import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String location;
    double salary;

    Employee(int id, String name, String location, double salary) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.salary = salary;
    }
}

public class Problem1 {
    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(101,"Rahul","Pune",25000));
        list.add(new Employee(102,"Priya","Hyderabad",30000));
        list.add(new Employee(103,"Amit","Chennai",28000));
        list.add(new Employee(104,"Kiran","Delhi",35000));
        list.add(new Employee(105,"Sneha","Mumbai",27000));

        Function<Employee,String> fun = e -> e.location;

        List<String> locations = list.stream()
                .map(fun)
                .collect(Collectors.toList());

        System.out.println(locations);
    }
}