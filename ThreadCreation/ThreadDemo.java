class ThreadDemo extends Thread{
    public void run(){
        System.out.println("Thread is running");
    }
    public static void main(String[] args){
        ThreadDemo t1 = new ThreadDemo();
        t1.setName("Scooty");
        System.out.println("Thread 1 : " +t1.getName());
        ThreadDemo t2 = new ThreadDemo();
        t2.setName("Shaggy");
        System.out.println("Thread 2 : " +t2.getName());
        t1.start();
        t2.start();
    }
}