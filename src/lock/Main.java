package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Worker1 worker1 = new Worker1();
        worker1.start();

        Worker2 worker2 = new Worker2();
        worker2.start();

        try {
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
            Container.increaseB();
        }
    }
}

class Worker2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            Container.increaseA();
            Container.increaseB();
        }
    }
}

class Container {
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static int a = 0; // resource
    public static int b = 0; // resource

    // deadlock
    public static void increaseA() {
        // ...
        lock1.lock();
        lock2.lock();
        a++;
        // ...
    }

    public static void increaseB() {
        // ...
        lock1.lock();
        lock2.lock();
        b++;
        // ...
    }
}
