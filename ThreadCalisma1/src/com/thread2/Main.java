package com.thread2;

public class Main {

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new Employee("ali"));
		Thread thread2 = new Thread(new Employee("mehmet"));
		
		thread1.start();
		thread2.start();
	
		System.out.println("Main thread calisiyor...");

	}

}
