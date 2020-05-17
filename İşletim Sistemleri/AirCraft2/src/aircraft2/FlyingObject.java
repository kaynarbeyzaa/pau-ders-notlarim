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

import java.util.concurrent.Semaphore;
public abstract class FlyingObject extends Thread{

    
    public int x;
    public int y;
    public int id;
    AirClass airclassObj;
    public boolean isAlive;
    
    public FlyingObject(int x, int y, int id, AirClass airclassObj, boolean isAlive)
    {
      this.x=x;
      this.y=y;
      this.id=id;
      this.airclassObj= airclassObj;
      this.isAlive=true;

    
    }
    
    
    public abstract void move();
    
    public abstract void check();
    
    public void run()
    {
    
        while(true)
        {
            int it=0;
            try {
                
                
                airclassObj.mutex.acquire();
                airclassObj.noOfArrivalThreads++;
                if(airclassObj.noOfArrivalThreads==airclassObj.noOfThreads)
                {
                    airclassObj.print();
                    airclassObj.control();
                    airclassObj.clear();
                    airclassObj.noOfArrivalThreads=0;
                    
                    for(Semaphore sem:airclassObj.semaphore )
                        sem.release();
                    
                    ///
                }
                
                airclassObj.mutex.release();
                airclassObj.semaphore[id].acquire();
                
                check();
                if(airclassObj.isDone)
                    break;
                if(isAlive==false)
                    break;
                move();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(FlyingObject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        
        }
    
    }
    
    
    
}
