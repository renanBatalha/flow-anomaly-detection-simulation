import java.util.List;
import java.util.LinkedList;

public class Consumer implements Runnable{
    private List <Packet> consumed = new LinkedList<>();
    private final Buffer buffer = Buffer.getInstance(); // shared buffer

    @Override 
    public void run(){
        try{
            while(true){
                Packet packet = buffer.getBufferElement();
                if(packet.getValue() > 0.9){
                    System.out.println(Thread.currentThread().getName() + "⚠ Anomaly Detected!!!");
                }
                else{
                    consumed.add(packet);
                    System.out.println(Thread.currentThread().getName() + "✔ Normal Packet at the flow.");
                }
                Thread.sleep(1000); // simulation of a processing time
            }
        } catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + "Consumer was stopped");
        }
    }

    public List<Packet> getConsumed(){
        return consumed;
    }    
}