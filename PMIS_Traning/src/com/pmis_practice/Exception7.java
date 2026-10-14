package exceptionhandling.com;
import java.util.*;
public class Exception7 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Number: ");
		int numerator = sc.nextInt();
		
		System.out.println("Enter the Denominator: ");
		int demo = sc.nextInt();
		
		try
		{
			int res = numerator/demo;
			System.out.println("Result: "+res);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Error: Cannot divide by zero");
		}
		finally
		{
			System.out.println("Program Executed.");
		}

	}

}
