public class Sample {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please pass a name as a command line argument.");
            return;
        }

        System.out.println("Welcome " + args[0]);
    }
}