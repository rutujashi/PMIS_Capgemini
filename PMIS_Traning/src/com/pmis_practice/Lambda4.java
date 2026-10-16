package java_8_example.com;
import java.util.function.*;
public class Lambda4 {

	public static void main(String[] args) {
		Consumer<String> pr = message -> System.out.println(message);
		pr.accept("hello I love cricket.");
		

	}

}
