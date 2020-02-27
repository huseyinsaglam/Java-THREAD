package com.Interrupt1;


import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Calisiyor....");
                
                
                for(int i= 1; i <= 10;i++) {
                    System.out.println("Thread Yaziyor : " + i);
                    
                    try {
                        Thread.sleep(1000);
                        System.out.println("Uykumun " + i + ". saniyesindeyim...");
                    } catch (InterruptedException ex) {
                        System.out.println("Uykum bolundu....");
                    }
                    
                }
                
            }
        });
        
        t.start();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.interrupt();
        
        
        
        
        
        
        
        
    }
}
