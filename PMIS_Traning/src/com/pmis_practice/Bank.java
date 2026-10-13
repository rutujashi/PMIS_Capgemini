package com.constuctor;

public class Bank {
	 String Account_holder;
     double balance;
     
     Bank(String Account_holder,double balance)
     {
    	this.Account_holder = Account_holder;
    	this.balance = balance;
     }
     void display()
     {
    	 System.out.println("Account Holder : "+Account_holder);
    	 System.out.println("Available Balance : "+balance);
     }
	
	void deposit(double amount)
	{
		balance += amount;
		System.out.println("Deposit : "+amount);
		System.out.println("Current Balance : "+balance);
	}
	
	void withdraw(double amount)
	{
		if(amount <= balance)
		{
			balance -= amount;
			System.out.println("Withdraw amount : "+amount);
			System.out.println("Updated balance : "+balance);
		}
		else
		{
			System.out.println("Insufficent Balance");
		}
	}
	public static void main(String[] args) {
		Bank b1 = new Bank("Rutuja Shinde",2000);
		b1.display();
		b1.deposit(400);
		b1.withdraw(500);
		

	}

}
