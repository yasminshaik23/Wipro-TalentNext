import java.util.Optional;
class Employee {
    int id;
    String name;
    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class InvalidEmployeeException extends RuntimeException {
    InvalidEmployeeException(String message) {
        super(message);
    }
}
public class Problem3 {
    public static void main(String[] args) {
        Employee emp = null; 
        Employee e = Optional.ofNullable(emp)
                .orElseThrow(() ->
                        new InvalidEmployeeException("Employee is null"));
        System.out.println("Employee Name: " + e.name);
    }
}