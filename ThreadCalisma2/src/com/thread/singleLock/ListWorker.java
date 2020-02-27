package com.thread.singleLock;


import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListWorker {
    
    Random random = new Random();
    ArrayList<Integer> list1 = new ArrayList<Integer>();
    ArrayList<Integer> list2 = new ArrayList<Integer>();
    
    /* synchronized anahtar kelimesi sadece bir tane thread girebilir anlamina gelir
	   o thread isini bitirmeden diger thread'in gecisine izin vermez... 
	   
	   synchronized demek ayni zamanda lock'lamak demekdir
	   
	   Burada iki tane synchronized metot var ama bir tane (anahtar) var. Hangi thread o anahtari
	   ilk once almýs ise ilk o anahtar ile butun synchronized olan metotlara girer ve isini bitirdikten sonra 
	   diger thread'e anahtarý teslim eder..
	    */
    
    public synchronized void list1DegerEkle(){
  
        try {
            Thread.sleep(1);
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        list1.add(random.nextInt(100));
        
       
        
    }
    public synchronized void list2DegerEkle(){
        
       try {
            Thread.sleep(1);
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        list2.add(random.nextInt(100));
        
        
    }
    public void degerAta(){
       
        for (int i = 0 ; i < 1000 ; i++) {
            list1DegerEkle();
            list2DegerEkle();
            
        }
     
    }
    public void calistir(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                degerAta();
                
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                degerAta();
                
            }
        });
        long baslangic = System.currentTimeMillis();
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("List1 Size :" + list1.size() + " List2 Size: " + list2.size());
        
        long bitis =  System.currentTimeMillis();
        
        System.out.println("Gecen Sure : " + (bitis - baslangic));
        
        
        
        
        
        
    }
    
    
}
