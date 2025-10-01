package atomicvariables;

import java.util.concurrent.atomic.AtomicInteger;

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


    }
}

class Worker1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Container.append("a1:" + i);
        }
    }
}

class Worker2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Container.append("a2:" + i);
        }
    }
}

class Container {
    public static AtomicInteger a = new AtomicInteger(0);
    public static StringBuffer sb = new StringBuffer();

    public static void increaseA() {
        a.incrementAndGet();
    }

    public static void append(String given) {
        sb.append(given);
    }
}
