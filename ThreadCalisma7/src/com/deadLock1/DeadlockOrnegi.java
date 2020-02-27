package com.deadLock1;


import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* Burada yazilan kod deadLock olusumuna neden olur */
public class DeadlockOrnegi {
    private Hesap hesap1 = new Hesap();
    private Hesap hesap2 = new Hesap();
    private Random random = new Random();
    
    private Lock lock1 = new ReentrantLock();
    
    private Lock lock2 = new ReentrantLock();
    
    
    public void thread1Fonksiyonu(){
      
    	
    	lock1.lock(); // lock1 anahtarý almasý gerekiyor..
    	lock2.lock(); // lock2 anahtarý almasý gerekiyor..
    	/* Buradaki kodun calismasi icin iki tane anahtara ihtiyac var..
    	 Birincisi lock1 ikincisi lock2'dir.*/
        for (int i = 0; i < 5000 ; i++) {
            
            Hesap.paraTransferi(hesap1, hesap2, random.nextInt(100));
            
        }
        lock1.unlock();
        lock2.unlock();
      
        
    }
    public void thread2Fonksiyonu(){

    	lock2.lock(); // lock2 anahtarý almasý gerekiyor..
    	lock1.lock(); // lock1 anahtarý almasý gerekiyor..
    	/* Buradaki kodun calismasi icin iki tane anahtara ihtiyac var..
   	      Birincisi lock2 ikincisi lock1'dir.*/
        for (int i = 0; i < 5000 ; i++) {
            
            Hesap.paraTransferi(hesap2, hesap1, random.nextInt(100));
            
        }
        lock2.unlock();
        lock1.unlock();
       
       
    }
    public void threadOver(){
        System.out.println("Hesap1 Bakiye : " + hesap1.getBakiye() + " Hesap2 Bakiye : " + hesap2.getBakiye());
        
        System.out.println("Toplam Bakiye : " + (hesap1.getBakiye() + hesap2.getBakiye()));
        
    }
}
