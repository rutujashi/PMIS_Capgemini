package exceptionhandling.com;

public class Exception2 {

	public static void main(String[] args) {
		try
		{
			int res = 10/0;
			System.out.println(res);
		    int[] number = {10,20,30};
		    System.out.println(number[5]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Invalid Array index");
		}
		catch(ArithmeticException e)
		{
			System.out.println("Cannot divide by 0");
		}

	}

}
