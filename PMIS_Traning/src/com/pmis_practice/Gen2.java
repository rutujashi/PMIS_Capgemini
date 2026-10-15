package genericexample.com;
import java.util.*;
public class Gen2 {

	public static void printList(List<?> list)
	{
		for(Object o : list)
		{
			System.out.println(o);
		}
	}
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Anish","Varun","Bhumi");
		List<Integer> nums = Arrays.asList(100,99,98);
		List<Double> prices = Arrays.asList(99.5,99.6,99.7);
		
		System.out.println("name: ");
		printList(names);
		
		System.out.println("\n Number: ");
		printList(nums);
		
		System.out.println("\nprice: ");
		printList(prices);
		

	}

}
