class EvenThread extends Thread {

    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.print(i + " ");
        }
    }
}

class OddThread extends Thread {

    public void run() {
        for (int i = 1; i <= 20; i += 2) {
            System.out.print(i + " ");
        }
    }
}

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {

        EvenThread t1 = new EvenThread();
        OddThread t2 = new OddThread();

        t1.start();

        t1.join();

        System.out.println();

        t2.start();
    }
}