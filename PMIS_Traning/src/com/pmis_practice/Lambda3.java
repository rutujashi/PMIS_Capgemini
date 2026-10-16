package java_8_example.com;
import java.util.*;
import java.util.function.Function;
public class Lambda3 {

	public static void main(String[] args) {
		
		Function<Integer, Integer> s = n -> n*n;
		
		System.out.println(s.apply(5));
		

	}

}
