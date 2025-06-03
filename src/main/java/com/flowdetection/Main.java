public class Main {

    public static void main(String[] args) {
        Thread producer1 = new Thread(new Producer(), "Producer-1");
        Thread consumer1 = new Thread(new Consumer(), "Consumer-1");
        Thread consumer2 = new Thread(new Consumer(), "Consumer-2");

        producer1.start();
        consumer1.start();
        consumer2.start();
    }
}
