import java.util.Random;

class ColourThread implements Runnable {

    public void run() {

        String colours[] = {
                "White", "blue", "black", "green", "red", "yellow"
        };

        Random r = new Random();

        while (true) {

            int index = r.nextInt(colours.length);

            System.out.println(colours[index]);

            if (colours[index].equalsIgnoreCase("red")) {
                System.out.println("Red found. Stopping...");
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {

        ColourThread obj = new ColourThread();

        Thread t = new Thread(obj);

        t.start();
    }
}