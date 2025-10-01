package threadswithrunnable;

// 1. extends Thread class
// 2. implements Runnable

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Worker1();
        runnable.run();

        Runnable runnable1 = new Worker2();
        runnable1.run();


    }
}

class Worker1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Worker1 worked!");
    }
}

class Worker2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Worker2 worked!");
    }
}
