package Inheritance_type;

class GrandParent{
	void vehicle()
	{
		System.out.println("This is Vehicle");
	}
}
class Parent extends GrandParent
{
	void bike()
	{
		System.out.println("This is bike");
	}
}
class Child extends Parent{
	void car()
	{
		System.out.println("This is Car");
	}
}
public class Multilevel_Inheritance {

	public static void main(String[] args) {
		
		Child c1 = new Child();
		c1.vehicle();
		c1.bike();
		c1.car();

	}

}
