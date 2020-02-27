package com.thread1;

public class Employee extends Thread {
	
	private String name;
	

	public Employee(String name) {
		super();
		this.name = name;
	}


	@Override
	public void run() {
		
		System.out.println( name +" calisiyor..");
		
		for(int i=1 ;i<=10;i++)
		{
			System.out.println(name + "yaziyor = " + i);
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
