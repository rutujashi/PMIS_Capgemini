package exceptionhandling.com;

public class Exception6 {

	public static void main(String[] args) {
		int balance = 5000;
		int withdrawal = 7000;
		try
		{
			if(withdrawal > balance)
			{
				throw new IllegalArgumentException("Insufficient Balance");
				
			}
			balance = withdrawal;
			System.out.println("Withdrawal was Successful");
			System.out.println("Remaining Balance: "+balance);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Program Completed.");

	}

}
