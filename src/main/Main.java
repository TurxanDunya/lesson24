package main;

// thread - worker

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        int i = 0;
        while (true) {
            System.out.println(++i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (i == 3) {
                break;
            }
        }

        System.out.println("End of thread");
    }
}
