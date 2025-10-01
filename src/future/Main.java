package future;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Worker1 worker1 = new Worker1();
        Worker2 worker2 = new Worker2();

//        new Thread(worker1).start(); // thread
//        new Thread(worker2).start(); // thread
    }
}

// task
class Worker1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return Container.increaseA();
    }
}

// task
class Worker2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return Container.increaseA();
    }
}

class Container {
    public static int a = 0;

    public synchronized static Integer increaseA() {
        return a++;
    }
}
