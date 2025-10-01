package threads;

// 1. extends Thread class
// 2. implements Runnable

public class Main {
    public static void main(String[] args) {
        Worker1 worker1 = new Worker1();
        worker1.setDaemon(true); // will be killed if main thread is killed
        worker1.start();

        Worker2 worker2 = new Worker2();
        worker2.start();

        try {
            // sure main thread waits for worker1 and worker2
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Container.a);
    }
}

class Worker1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            Container.increaseA();
        }
    }
}

class Worker2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            Container.increaseA();
        }
    }
}

class Container {
    public static int a = 0; // resource

    // race condition
    public synchronized static void increaseA() {
        a++;
    }
}
