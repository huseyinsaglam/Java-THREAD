package com.semaphore;


import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SemaphoreOrnegi {
    /* Semaphore Ayný anda birden fazla thread calýsmasýna olanak saglar.. */
    private Semaphore sem = new Semaphore(3);
    
    public void threadFonksiyonu(int id) {
        
        try {
            sem.acquire(); // semaphore degerine bakýyor eger semaphore degeri 0 degilse alt taraftaki kodlari okuyor
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaphoreOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Thread Basliyor... ID : " + id );
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaphoreOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread Cikiyor.... ID : " + id);
        
        sem.release(); // semaphore degeri 0 ise degeri bir artýrýyor
        
    }
    
}
