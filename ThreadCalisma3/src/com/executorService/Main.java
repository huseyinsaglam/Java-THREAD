package com.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        
         ExecutorService executor = Executors.newFixedThreadPool(2);
        /* bu durumda her seferinde en fazla iki tane thread
          havuzu olusturuyor ve yonetimini ExecutorService ' ne birakiyor..  */
        for (int i = 1 ;  i <=5 ;i++){
            
            executor.submit(new Worker(String.valueOf(i), i));
            
        }
        
        executor.shutdown();
        System.out.println("Butun isler teslim edildi...");
        
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
          } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }  
         System.out.println("Butun isler bitti...");   
    	
    	
            
         
        
    }
    
}
