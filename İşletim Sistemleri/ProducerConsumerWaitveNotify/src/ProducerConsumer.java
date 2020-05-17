
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {
    Random random = new Random();
    Object lock =  new Object();
    Queue<Integer> queue = new LinkedList<Integer>();
    private int limit = 10;
    
    
    
    public void produce() {
        
        while (true) {
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            synchronized(lock) {
                
                if (queue.size() == limit) {
                    
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                Integer value = random.nextInt(100);
                queue.offer(value);
                System.out.println("Producer Üretiyor : " + value);
                lock.notify();
                
            }
      
        }
        
        
    }
    public void consume(){
        
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            synchronized(lock) {
                
                if (queue.size() == 0) {
                    
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                Integer value =  queue.poll();
                System.out.println("Consumer Tüketiyor : " + value);
                System.out.println("Queue Size : " + queue.size());
                lock.notify();
                
                
            }
            
        }
        
      
    }
   
    
    
}
