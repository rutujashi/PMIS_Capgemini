package java_8_example.com;
import java.util.*;
import java.util.function.Function;
public class Lambda2 {

	public static void main(String[] args) {
		Function<String, Integer> getlength = name -> name.length();
		System.out.println(getlength.apply("java"));
		System.out.println(getlength.apply("John"));
		

	}

}
