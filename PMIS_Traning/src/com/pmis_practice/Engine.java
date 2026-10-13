package Isarelationship.com;

class Engine {
	void start()
	{
		System.out.println("Engine is starttt............");
	}

}
class Car
{
	private Engine engine;
	Car()
	{
		this.engine = new Engine();
	}
	void drive()
	{
		engine.start();
		System.out.println("Car is Start");
	}
}
