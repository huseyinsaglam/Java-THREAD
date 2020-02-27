package com.thread;

public class ThreadSafe {
	
	private int count = 0;
	
	public void threadcalistir()
	{
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0 ;i<5000 ; i++)
				{
					count++;
				}
				
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5000; i++) {
					count++;
				}

			}
		});
		
		
		thread1.start();
		thread2.start();
		   try {
				thread1.join(); // thread1 isinin bitmesini bekliyor.. Asagidaki kodları okumuyor
				thread2.join(); // thread2 isinin bitmesini bekliyor.. Asagidaki kodları okumuyor
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	   System.out.println("Count degeri = " + count);
	   
	
	}

	public static void main(String[] args) {
		
		ThreadSafe threadSafe = new ThreadSafe();
		
		threadSafe.threadcalistir();
	}

}
