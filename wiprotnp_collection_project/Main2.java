import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Box> boxes = new TreeSet<>(new Comparator<Box>() {

            @Override
            public int compare(Box b1, Box b2) {

                if (b1.getVolume() < b2.getVolume())
                    return -1;
                else if (b1.getVolume() > b2.getVolume())
                    return 1;
                else
                    return 0;
            }
        });

        System.out.println("Enter the number of Box");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("Enter the Box " + i + " details");

            System.out.println("Enter Length");
            double length = sc.nextDouble();

            System.out.println("Enter Width");
            double width = sc.nextDouble();

            System.out.println("Enter Height");
            double height = sc.nextDouble();

            boxes.add(new Box(length, width, height));
        }

        System.out.println("Unique Boxes in the Set are");

        for (Box b : boxes) {
            System.out.println(b);
        }

        sc.close();
    }
}