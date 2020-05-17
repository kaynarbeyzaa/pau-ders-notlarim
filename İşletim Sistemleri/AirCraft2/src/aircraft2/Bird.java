/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircraft2;

import java.util.Random;

/**
 *
 * @author acar
 */
public class Bird extends FlyingObject {

    Random rnd;
    
    public Bird(int x, int y, int id, AirClass airclassObj, boolean isAlive)
    {
    
        
        //int x, int y, int id, AirClass airclassObj, boolean isAlive
         super( x,  y,  id,  airclassObj,  isAlive);
          rnd=new Random();
          this.x=rnd.nextInt(airclassObj.maxX);
          this.y=rnd.nextInt(airclassObj.maxY);
          
          airclassObj.mutexNew.lock();
          airclassObj.airPlane[this.x][this.y][1]++;
          airclassObj.mutexNew.unlock();
    }
    
    @Override
    public void move() {
        
        int a=rnd.nextInt(5)-2;
        int b=rnd.nextInt(5)-2;
        
        x+=a;
        y+=b;
        
        if(x<0)
            x=0;
        if(y<0)
            y=0;
        if(x>=airclassObj.maxX)
            x=airclassObj.maxX-1;
        
        if(y>=airclassObj.maxY)
            y=airclassObj.maxY-1;
        
         airclassObj.mutexNew.lock();
         airclassObj.airPlane[x][y][1]++;
         airclassObj.mutexNew.unlock();


//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void check() {
        
        
        
        if(airclassObj.airPlane[x][y][1]==-1)
        {
             isAlive=false;
             airclassObj.airPlane[x][y][1]=0;
        
        
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    
    
    }
    
}
