package oop.com;

class Vehicle
{
	String brand;
	
	void startEngine()
	{
		System.out.println(brand+ "engine started.");
	}
}

class Bike extends Vehicle
{
	boolean hasCarrier;
	
	void kickStand()
	{
		System.out.println("Kicktstand put down");
	}
}
public class Inheritance {

	public static void main(String[] args) {
		
		Bike b1 = new Bike();
		b1.brand = " shine ";
		b1.startEngine();
		b1.kickStand();

	}

}
