import java.util.Random;

public class Producer implements Runnable {
    private final Buffer buffer = Buffer.getInstance();
    private final Random random = new Random();

    @Override
    public void run() {
        try {
            while (true) {
                double value = random.nextDouble(); // range [0.0, 1.0)
                Packet packet = new Packet(value);
                buffer.addBuffer(packet);

                System.out.println(Thread.currentThread().getName() + " ➕ Produced packet: " + value);

                Thread.sleep(300); // simulate production time
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " Producer was stopped.");
        }
    }
}
