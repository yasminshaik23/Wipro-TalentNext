import java.io.*;
import java.util.*;

public class EmployeeManagement {

    static final String FILE_NAME = "employee.dat";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\nMain Menu");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Employee Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();

                    Employee emp = new Employee(id, name, age, salary);

                    addEmployee(emp);

                    break;

                case 2:
                    displayEmployees();
                    break;

                case 3:
                    System.out.println("Exiting the System");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 3);

        sc.close();
    }
    static void addEmployee(Employee emp) {

        ArrayList<Employee> list = readEmployees();

        list.add(emp);

        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FILE_NAME));

            oos.writeObject(list);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static ArrayList<Employee> readEmployees() {

        File file = new File(FILE_NAME);

        if (!file.exists())
            return new ArrayList<>();

        try {

            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FILE_NAME));

            ArrayList<Employee> list =
                    (ArrayList<Employee>) ois.readObject();

            ois.close();

            return list;

        } catch (Exception e) {

            return new ArrayList<>();
        }
    }
    static void displayEmployees() {

        ArrayList<Employee> list = readEmployees();

        System.out.println("----Report-----");

        for (Employee e : list) {
            System.out.println(e);
        }

        System.out.println("----End of Report-----");
    }
}