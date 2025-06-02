import java.util.List;
import java.util.LinkedList;

public class Buffer{
    //Singleton: Unique Instance
    private static final Buffer bufferInstance = new Buffer(10); // buffer capacity
    private List<Packet> bufferOfPackets = new LinkedList<>(); // null linked list
    private final int capacity;

    private Buffer(int capacity){
        this.capacity = capacity;
        this.bufferOfPackets = new LinkedList<>();
    }

    // public method to singleton class access
    public static Buffer getInstance(){
        return bufferInstance;
    }

    public synchronized void addBuffer(Packet packet) throws InterruptedException{
        while(bufferOfPackets.size() == capacity){
            wait(); // producer sleeps
        }

        bufferOfPackets.add(packet);

        notifyAll(); // consumers are alerted
    }
    
    public synchronized Packet getBufferElement() throws InterruptedException {
        while(bufferOfPackets.isEmpty()){
            wait(); // wait for new packets
        }

        Packet firstInLine = bufferOfPackets.remove(0);

        notifyAll();
        return firstInLine;      
    }
}