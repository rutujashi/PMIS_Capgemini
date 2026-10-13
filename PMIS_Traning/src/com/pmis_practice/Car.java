package com.constuctor;

public class Car {

	String color;
	String brand;
	int speed;
	
	Car(String color, String brand, int speed)
	{
		this.color = color;
		this.brand = brand;
		this.speed = speed;
	}
	
	void display()
	{
		System.out.println(color+"\n"+brand+"\n"+speed);
	}
	
	void increspeed(int incre)
	{
		int or_speed = speed; 
		speed += incre ;
		System.out.println("Original Speed : "+speed);
		System.out.println(brand+"Accelreted by : "+speed+"km/hr");
	}
	public static void main(String[] args) {
		
		Car c1 = new Car("Black","BMW",120);
		c1.display();
		c1.increspeed(50);
		

	}

}
