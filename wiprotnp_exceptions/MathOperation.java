public class MathOperation {
    public static void main(String[] args) {
        try {
            if (args.length != 5) {
                System.out.println("Please enter exactly 5 integers.");
                return;
            }
            int[] arr = new int[5];
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                arr[i] = Integer.parseInt(args[i]);
                sum += arr[i];
            }
            double average = (double) sum / arr.length;
            System.out.println("Sum = " + sum);
            System.out.println("Average = " + average);
        } catch (NumberFormatException e) {
            System.out.println("java.lang.NumberFormatException");
        } catch (ArithmeticException e) {
            System.out.println("java.lang.ArithmeticException");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}