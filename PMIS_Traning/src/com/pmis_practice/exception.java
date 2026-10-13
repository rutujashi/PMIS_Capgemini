package exceptionhandling.com;

public class exception {

	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		
		try {
			int rest = a/b;
			System.out.println("rest");
		}
		catch(ArithmeticException e)
		{
			System.out.println("You cannot divine by 0.");
		}
		
	}

}

