/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepingbarber;

import java.util.concurrent.Semaphore;

/**
 *
 * @author acar
 */
public class SleepingBarber {
    
    
    static Semaphore barber=new Semaphore(1);
    static Semaphore customer=new Semaphore(0);
    static Semaphore mutex=new Semaphore(1);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Thread hasan=new Barber(barber,customer);
        Thread [] musteriler=new Customer[19];
        
        hasan.start();
        
       
        for(int i=0; i<19;i++)
            musteriler[i]=new Customer(i,barber,customer,mutex,5); 
        
        for (int i=0; i<19; i++)
        {
             musteriler[i].start();
        }
        // TODO code application logic here
        
    }
    
}
