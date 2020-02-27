package com.ReentrantLock;


import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReentrantLockOrnegi {
    
  
    private int say = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    
    public void artir(){
        for (int i = 0 ;  i < 10000 ; i++) {
            
            say++;
        }
        
        
    }
    /* synchronized ile ayný gibi dusunebiliriz ReentractLock ' lamayi thread'i locklama islemini yapiyor..
     Bir baska bir thread' in girmemesini sagliyor.. 
     Burada synchronized 'de yapilan wait ve notify islemini ReentrantLock 'ta ise; Condition aracýlýgýyla olusan ReentrantLock
     üzerine await ve signal islemi ile yapiyoruz  */
    public void thread1Fonksiyonu(){
        
        lock.lock(); // burada thread' i lock'lama islemini baslatiyor..Anahtarý aliyor
        System.out.println("Thread 1 Calisiyor...");
        System.out.println("Thread 1 Uyandirmayi Bekliyor....");
        
        try {
            condition.await(); // burada thread'i lock'lamayý bitiriyor..thread'i uyutuyor..Anahtarý birakiyor
        } catch (InterruptedException ex) {
            Logger.getLogger(ReentrantLockOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread 1 Uyandirildi ve islemine Devam Ediyor....");
        
        artir();
       	lock.unlock(); // burada thread' i lock'lama islemini bitiriyor..Anahtari teslim ediyor..
		
       
       
        
       
        
        
        
    }
    public void thread2Fonksiyonu(){
    	
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReentrantLockOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner scanner = new Scanner(System.in);
        
        
        lock.lock(); // burada thread' i lock'lama islemini baslatiyor..Anahtarý aliyor
        System.out.println("Thread 2 Calisiyor....");
        
        artir();
        System.out.println("Devam etmek icin bir tusa basin...");
        scanner.nextLine();
        condition.signal(); // burada uyuyan thread'i uyandýrma islemini yapiyor..
        System.out.println("Thread 1'i Uyandirdim.Ben gidiyorum...");
       
        lock.unlock(); // burada thread' i lock'lama islemini bitiriyor..Anahtarý teslim ediyor..
        
        
        
        
        
    }
    public void threadOver(){
        System.out.println("Say degiskenin degeri : " + say);
        
        
    }
}
