import java.util.*;

class Employee {
    int empId;
    String empName;
    float salary;
    Employee(int empId, String empName, float salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }
    public String toString() {
        return "Employee ID: " + empId +
               ", Name: " + empName +
               ", Salary: " + salary;
    }
}

public class Problem7 {
    public static void main(String[] args) {
        Vector<Employee> employees = new Vector<>();
        employees.add(new Employee(101, "Rahul", 50000));
        employees.add(new Employee(102, "Priya", 60000));
        employees.add(new Employee(103, "Amit", 45000));
        System.out.println("Employees using Iterator:");
        Iterator<Employee> itr = employees.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("\nEmployees using Enumeration:");
        Enumeration<Employee> en = employees.elements();

        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
    }
}