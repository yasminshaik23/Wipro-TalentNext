public class RaceThread extends Thread {

    static volatile boolean raceFinished = false;

    public RaceThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        for (int i = 1; i <= 100 && !raceFinished; i++) {

            System.out.println(getName() + " ran " + i + " meters");
            if (getName().equals("Hare") && i == 60) {
                try {
                    System.out.println("\nHare is sleeping for 1 second...\n");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

           
            if (i == 100 && !raceFinished) {
                raceFinished = true;
                System.out.println("\n*********");
                System.out.println(getName() + " wins the race!");
                System.out.println("*********");
            }
        }
    }
}