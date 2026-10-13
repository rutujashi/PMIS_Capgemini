package exceptionhandling.com;

public class Excepetion1 {

	public static void main(String[] args) {
		try {
			int num = 10/0;
			System.out.println(num);
		}
		catch(ArithmeticException e)
		{
			System.out.println("do not divide by 0");
		}

	}

}
