package executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Salam");

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.scheduleWithFixedDelay(task, 1000, 1000, TimeUnit.MILLISECONDS);

        try {
            TimeUnit.SECONDS.sleep(15); // Let the tasks run for 15 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown(); // Shut down the scheduler
            System.out.println("Scheduler shut down.");
        }
    }
}
