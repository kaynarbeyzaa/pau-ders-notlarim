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
public class Barber extends Thread {
    
    Semaphore barber=new Semaphore(1);
    Semaphore customer=new Semaphore(0);
    
    public Barber(Semaphore barber, Semaphore customer)
    {
      this.barber=barber;
      this.customer=customer;
    }
    
    @Override
    public void run()
    {
        System.out.println("Hasan başladı");
            while(true){
                try {
                    customer.acquire(); // Burada beklerse müşterinin gelmesini bekleyip uyuyor
                    // Müşterinin saçını kesiyor
                    hair_cut();
                    //barber.release();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Barber.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    public void hair_cut()
    {
        try {
            System.out.println("Şu anda saç kesiyorum");
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Barber.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
