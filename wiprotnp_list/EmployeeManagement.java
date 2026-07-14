public class EmployeeManagement {

    public static void main(String[] args) {

        EmployeeDB db = new EmployeeDB();

        Employee e1 = new Employee(101, "Rahul", "rahul@gmail.com", "Male", 50000);
        Employee e2 = new Employee(102, "Priya", "priya@gmail.com", "Female", 60000);
        Employee e3 = new Employee(103, "Amit", "amit@gmail.com", "Male", 45000);
        db.addEmployee(e1);
        db.addEmployee(e2);
        db.addEmployee(e3);
        System.out.println("Employee Details:");
        db.displayEmployees();
        if (db.deleteEmployee(102))
            System.out.println("Employee Deleted Successfully.");
        else
            System.out.println("Employee Not Found.");
        System.out.println();

        System.out.println("Employee Details After Deletion:");
        db.displayEmployees();

        System.out.println();
        System.out.println(db.showPaySlip(101));
    }
}