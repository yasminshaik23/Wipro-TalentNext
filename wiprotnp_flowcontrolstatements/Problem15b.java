public class Problem15b {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please enter an integer number");
            return;
        }

        int n = Integer.parseInt(args[0]);

        int i = 1;

        while (i <= n) {

            int j = 1;

            while (j <= i) {
                System.out.print("* ");
                j++;
            }

            System.out.println();
            i++;
        }
    }
}