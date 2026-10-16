package java_8_example.com;
import java.util.function.*;
public class Lambda6 {

	public static void main(String[] args) {
		Consumer<String> s = mobno -> {
			System.out.println("Sending the otp to the ph no.: "+mobno);
			
		};
		
		s.accept("+91 8769869559");

	}

}
