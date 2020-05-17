/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircraft2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author acar
 */
public class AirClass {
    
    public int [][][] airPlane;
    public int maxX;
    public int maxY;
    public int noOfThreads;
    public int noOfArrivalThreads;
    public boolean isDone;
    public int failTimes;
    public Semaphore mutex;
    public Semaphore[] semaphore;
    ReentrantLock mutexNew;
    
    
    public AirClass(int maxX, int maxY,int noOfthreads)
    {
        this.maxX=maxX;
        this.maxY=maxY;
        this.noOfThreads=noOfthreads;
        airPlane =new int [maxX][maxY][2];
        isDone=false;
        failTimes=0;
        mutex=new Semaphore(1);
        mutexNew=new ReentrantLock();
        semaphore=new Semaphore[noOfthreads+1];
        for (int i=0; i<noOfthreads+1; i++)
            semaphore[i]=new Semaphore(0);
    
    }
    
    
    public void print()
    {
       for (int i=maxX-1; i>=0; i--){
           for(int j=0;j<maxY; j++){
               for(int z=0;z<2; z++){
                 if(airPlane[i][j][z]>0)
                       System.out.print(airPlane[i][j][z]+((z==0)? "P":"B"));
                 else
                     System.out.print("--");
               }
               System.out.print("  ");
           }
           System.out.println(" ");
       }
    
        System.out.println(" ");
    }
    
    public void control()
    {
        for (int i=maxX-1; i>=0; i--)
           for(int j=0;j<maxY; j++)
           {
                   if(airPlane[i][j][0]>0 && airPlane[i][j][1]>0)
                   {
                       System.out.println("Çakışma var");
                       failTimes+=airPlane[i][j][1];
                       noOfThreads-=airPlane[i][j][1];
                       airPlane[i][j][1]=-1;
                       break;
                   }
           }
        
        if(failTimes>1){
               isDone=true;
               System.out.println("Uçak düştü");
               
           }
        if(airPlane[maxX-1][maxY-1][0]==1 )
        {
            //System.out.println("Uçak Erişti.");
            isDone=true;
                   
        }
        
        
    }
    
    public void clear()
    {
    
         for (int i=maxX-1; i>=0; i--)
           for(int j=0;j<maxY; j++)
           {
                   airPlane[i][j][0]=0;
                   if(airPlane[i][j][1]!=-1)
                     airPlane[i][j][1]=0;
           }
                   
               
                 
        
    }
    
}
