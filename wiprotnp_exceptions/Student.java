import java.util.Scanner;
class NegativeValuesException extends Exception {
    public NegativeValuesException(String message) {
        super(message);
    }
}
class OutOfRangeException extends Exception {
    public OutOfRangeException(String message) {
        super(message);
    }
}
public class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            for (int i = 1; i <= 2; i++) {
                System.out.println("Enter the name of student " + i + ":");
                String name = sc.nextLine();
                int total = 0;
                System.out.println("Enter marks in 3 subjects:");
                for (int j = 1; j <= 3; j++) {
                    int mark = Integer.parseInt(sc.nextLine());
                    if (mark < 0) {
                        throw new NegativeValuesException("Negative Values Exception");
                    }
                    if (mark > 100) {
                        throw new OutOfRangeException("Out of Range Exception");
                    }
                    total += mark;
                }
                double average = total / 3.0;
                System.out.println("Student Name : " + name);
                System.out.println("Average Marks : " + average);
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Number Format Exception");
        }
        catch (NegativeValuesException e) {
            System.out.println(e.getMessage());
        }
        catch (OutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}