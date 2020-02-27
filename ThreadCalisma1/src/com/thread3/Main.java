package com.thread3;

public class Main {

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new Runnable(){
			
			@Override
			public void run() {
				System.out.println ("Thread calisiyor..");
				
				for(int i=1 ;i<=10;i++)
				{
					System.out.println( "yaziyor = " + i);
					
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		System.out.println("Main thread calisiyor...");
		thread1.start();

	}

}
