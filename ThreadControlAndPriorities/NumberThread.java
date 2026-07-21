class NumberThread extends Thread {

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);

            if (i == 5) {
                try {
                    Thread.sleep(5000); // 5 seconds
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberThread t = new NumberThread();
        t.start();
    }
}