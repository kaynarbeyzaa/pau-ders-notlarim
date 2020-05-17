
package com.mustafamurat.thread1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Printer extends Thread{

    @Override
    public void run() {
        System.out.println(isim + " Çalışıyor...");
        
        for (int i = 1 ; i <= 10 ; i++){
            try {
                System.out.println(isim + " Yazıyor : " + i);
                
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Thread kesintiye uğradı..");
            }
            
            
            
        }
        System.out.println(isim + " işini bitirdi...");
    }
    
    private String isim;

    public Printer(String isim) {
        this.isim = isim;
    }
    
    
    
}
