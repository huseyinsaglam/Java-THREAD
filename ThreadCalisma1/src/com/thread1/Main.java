package com.thread1;

public class Main {

	public static void main(String[] args) {
		
		Employee employee1 = new Employee("Ali");
		Employee employee2 = new Employee("Mehmet");
		
		employee1.start();
		employee2.start();
	
		System.out.println("Main thread calisiyor...");

	}

}
