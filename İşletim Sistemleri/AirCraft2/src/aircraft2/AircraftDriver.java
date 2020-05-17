/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircraft2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acar
 */
public class AircraftDriver {
    
    
    public static void main(String[] args) {
        
        AirClass air=new AirClass(10,10,21);
        Thread[] threads=new Thread[21];
        for(int i=0; i<20;i++)
        {   
           threads[i]=new Bird(0,  0, i,  air,  true);
           threads[i].start();
  
        }
        
        threads[20]=new Plane(0,  0, 20,  air,  true);
        threads[20].start();
        
        for(int i=0; i<21;i++)
        {   
          
            try {
                threads[i].join();
                System.out.println("Thread çıktı"+i);
            } catch (InterruptedException ex) {
                Logger.getLogger(AircraftDriver.class.getName()).log(Level.SEVERE, null, ex);
            }
  
        }
        
    }
    
    
            
    
}
