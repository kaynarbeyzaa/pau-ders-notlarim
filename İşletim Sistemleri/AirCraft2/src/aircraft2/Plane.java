/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircraft2;

/**
 *
 * @author acar
 */
public class Plane extends FlyingObject {

    
    public Plane(int x, int y, int id, AirClass airclassObj, boolean isAlive)
    {  
        super( x,  y,  id,  airclassObj,  isAlive);
         airclassObj.airPlane[0][0][0]=1;
    }    
    
    @Override
    public void move() {
        
        
        this.x=x+1;
        this.y=y+1;
        if(x<=(airclassObj.maxX-1) && y<=(airclassObj.maxY-1))
        {
           airclassObj.airPlane[x][y][0]=1;
          
        }
        else{
          if(x>= airclassObj.maxX)
              x=airclassObj.maxX-1;
          
          if(y>= airclassObj.maxY)
              y=airclassObj.maxY-1;
        
        
        
        }
        
        airclassObj.airPlane[x][y][0]=1;
         
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void check() {
        
        if(x==(airclassObj.maxX-1) && y==(airclassObj.maxY-1))
        {
            System.out.println("Uçak Erişti.");
            airclassObj.isDone=true;
                   
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
