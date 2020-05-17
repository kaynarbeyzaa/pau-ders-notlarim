/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepingbarber;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author acar
 */
public class Customer extends Thread{
    private int ID;
    Semaphore barber;
    Semaphore customer;
    Semaphore mutex;
    private int capacity;
    public static int numberOfCustomers=0;
    
    
    public Customer(int id,Semaphore barber,Semaphore customer,Semaphore mutex,int capacity)
    {
      this.ID=id;
      this.barber=barber;
      this.customer=customer;
      this.mutex=mutex;
      this.capacity=capacity;
    }
    @Override
    public void run()
    {
        boolean haircut=true;
        System.out.println("Thread "+ID +" başladı, mutexi kapmaya çalışıyor");
        
        try {
            mutex.acquire();
            System.out.println("Dükkandaki müşteri sayısı "+numberOfCustomers);
            if (numberOfCustomers==(capacity+1))
            {
               haircut=false;
               mutex.release();
               System.out.println("Ben Thread "+ID+" Dükkan DOLU!!, çıkıyorum");
            
            }
            else
            {
              
              numberOfCustomers++;
              mutex.release();
            }
           
            if(haircut)
            {
               customer.release();
               barber.acquire(); // Barber 1 ile başlatıldığı için sadece bir kişi saç kestirebilir
               // Saç kestirme
               System.out.println("Ben Thread "+ID+" saçım kesiliyor");
               Thread.sleep(2000);
               System.out.println("Ben Thread "+ID+" artık çıkıyorum");
               mutex.acquire();
               numberOfCustomers--;
               System.out.println("Dükkandaki Müşteri sayısı "+numberOfCustomers);
               mutex.release();
               barber.release();
            }  
        } catch (InterruptedException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
