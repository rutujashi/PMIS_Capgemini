package exceptionhandling.com;

public class Finally1 {

	public static void main(String[] args) {
		try
		{
			int res = 10/0;
		}
		catch(ArithmeticException e)
		{
			System.out.println("Cannot divide by 0");
		}
		finally
		{
			System.out.print("Finally block exception");
		}

	}

}
