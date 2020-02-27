package com.WaitAndNotify;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class WaitNotify {
    private Object lock = new Object();
    
    public void thread1Fonksiyonu() {
        
        synchronized(lock) {
        	 System.out.println("Thread 1 Calisiyor....");
             System.out.println("Thread 1 Thread2'nin kendisini uyandirmasini bekliyor...");
            
            try {
                lock.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Thread 1 Uyandi. Devam Ediyor...");
           
        }
        
    }
    public void thread2Fonksiyonu() {
        Scanner scanner = new Scanner(System.in);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
        }
        synchronized(lock) {
        	 System.out.println("Thread 2 Calisiyor....");
             
             System.out.println("Devam etmek icin bir tusa basin....");
            
            scanner.nextLine();
            
            
            lock.notify();
            System.out.println("Uyandirdim abi.Ben gidiyorum Ama 2 saniye bekle...");
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        
        
    }
    
    
    
}
