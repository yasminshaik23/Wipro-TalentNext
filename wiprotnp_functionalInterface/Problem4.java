import java.util.*;
import java.util.function.Predicate;

class Employee{

    private int id;
    private String name;
    private double salary;

    Employee(int id,String name,double salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }
}

public class Problem4{

    public static void main(String[] args){

        ArrayList<Employee> list=new ArrayList<>();

        list.add(new Employee(1,"Rahul",9000));
        list.add(new Employee(2,"Priya",15000));
        list.add(new Employee(3,"Amit",8000));
        list.add(new Employee(4,"Sneha",25000));
        list.add(new Employee(5,"Kiran",7000));

        Predicate<Employee> p=e->e.getSalary()<10000;

        list.stream()
            .filter(p)
            .forEach(e->System.out.println(e.getName()));
    }
}