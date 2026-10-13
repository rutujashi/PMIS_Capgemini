package exceptionhandling.com;
import java.util.*;
public class Exception4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Age : ");
		int age = sc.nextInt();
		
		if(age < 0)
		{
			throw new IllegalArgumentException("Age Cannot be negative");
		}
		System.out.println("Age: "+age);

	}

}
