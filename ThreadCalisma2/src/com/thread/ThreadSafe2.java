package com.thread;

public class ThreadSafe2 {
	
	private int count = 0;
	/* synchronized anahtar kelimesi sadece bir tane thread girebilir anlamina gelir
	   o thread isini bitirmeden diger thread'in gecisine izin vermez...  */
	public synchronized void arttir()
	{
		count++;
	}
	
	public void threadcalistir()
	{
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0 ;i<5000 ; i++)
				{
					arttir();
				}
				
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5000; i++) {
					arttir();
				}

			}
		});
		
		
		thread1.start();
		thread2.start();
		   try {
				thread1.join(); 
				thread2.join(); 
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	   System.out.println("Count degeri = " + count);
	   
	
	}

	public static void main(String[] args) {
		
		ThreadSafe2 threadSafe = new ThreadSafe2();
		
		threadSafe.threadcalistir();
	}

}
