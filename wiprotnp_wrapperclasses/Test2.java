class Employee implements Cloneable {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emp1 = new Employee(101, "Yasmin", 50000);
        Employee emp2 = (Employee) emp1.clone();
        emp1.id = 102;
        emp1.name = "Ayesha";
        emp1.salary = 60000;
        System.out.println("Original Employee:");
        System.out.println("ID: " + emp1.id);
        System.out.println("Name: " + emp1.name);
        System.out.println("Salary: " + emp1.salary);
        System.out.println("\nCloned Employee:");
        System.out.println("ID: " + emp2.id);
        System.out.println("Name: " + emp2.name);
        System.out.println("Salary: " + emp2.salary);
    }
}