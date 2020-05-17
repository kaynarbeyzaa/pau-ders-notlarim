
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
          ProducerConsumer pc = new ProducerConsumer();
    
    Thread producer = new Thread(new Runnable() {
        @Override
        public void run() {
            pc.produce();
        }
    });
    Thread consumer = new Thread(new Runnable() {
        @Override
        public void run() {
            pc.consume();
        }
    });

    producer.start();
    consumer.start();
    
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
  
}
