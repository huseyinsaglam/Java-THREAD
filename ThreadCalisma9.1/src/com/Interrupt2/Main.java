package com.Interrupt2;


import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        
        List<Integer> list =  new LinkedList<Integer>();
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Calisiyor....");
                
                for (int i = 0 ; i < 1000000 ;i++){
                    
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Kesintiye Ugradi....");
                        return;
                        
                    }
                    
                    list.add(i);
                   
                }
                
                System.out.println("Thread kesintiye ugramadan isini bitirdi...");
            }
        });
        
        t.start();
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.interrupt();
        
        
        
        
        
        
        
        
    }
}
