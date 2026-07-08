import java.util.Scanner;
public class VideoLauncher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VideoStore vs = new VideoStore();
        int choice;
        do {
            System.out.println("\nMAIN MENU");
            System.out.println("=========");
            System.out.println("1. Add Videos");
            System.out.println("2. Check Out Video");
            System.out.println("3. Return Video");
            System.out.println("4. Receive Rating");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter video name: ");
                    String name = sc.nextLine();
                    vs.addVideo(name);
                    break;
                case 2:
                    System.out.print("Enter video name: ");
                    name = sc.nextLine();
                    vs.doCheckout(name);
                    break;
                case 3:
                    System.out.print("Enter video name: ");
                    name = sc.nextLine();
                    vs.doReturn(name);
                    break;
                case 4:
                    System.out.print("Enter video name: ");
                    name = sc.nextLine();
                    System.out.print("Enter rating: ");
                    int rating = sc.nextInt();
                    vs.receiveRating(name, rating);
                    break;
                case 5:
                    vs.listInventory();
                    break;
                case 6:
                    System.out.println("Exiting...!! Thanks for using the application.");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);
    }
}