package java_8_example.com;
import java.util.function.*;
public class Lambda5 {

	public static void main(String[] args) {
		Supplier<String> m = () -> "Welcome to the world.";
		System.out.println(m.get());

	}

}
