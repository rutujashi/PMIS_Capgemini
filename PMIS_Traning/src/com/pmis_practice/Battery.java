package hasarelationship.com;

class Battery {
	int capcity;
	Battery(int capcity)
	{
		this.capcity = capcity;
	}
	
	void drain()
	{
		System.out.println("Battery Used.\n Capacity remaining: "+(capcity - 100)+"M");
	}

}
class Camera
{
	int pix;
	Camera(int pix)
	{
		this.pix = pix;
	}
	void takePhoto()
	{
		System.out.println("Click.... Captured a photo with "+pix+" sensor");
	}
}
class Phone
{
	String brand;
	Battery battery;
	Camera camera;
	
	Phone(String brand, Battery battery, Camera camera)
	{
		this.brand = brand;
		this.battery = battery;
		this.camera = camera;
	}
	
	void snapicture()
	{
		System.out.println(" [ "+brand+" ] "+" is active");
		camera.takePhoto();
		battery.drain();
	}
}
