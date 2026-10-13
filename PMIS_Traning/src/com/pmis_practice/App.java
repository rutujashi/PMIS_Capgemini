package hasarelationship.com;

public class App {

	public static void main(String[] args) {
		Battery b = new Battery(250);
		Camera c = new Camera(450);
		Phone p = new Phone("Pixel",b,c);
		
		p.snapicture();

	}

}
