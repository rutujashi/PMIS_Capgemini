package Inheritance_type;

class BankAccount
{
	void AccountDetail()
	{
		System.out.println("Enter Account Datails");
	}
}
class FixDeposit extends BankAccount
{
	void deposit()
	{
		System.out.println("Deposit the Amount");
	}
}
class SavingAccount extends BankAccount
{
	void savinginfo()
	{
		System.out.println("Saving Details  ");
	}
}
public class Hierarchical_Inheritance {

	public static void main(String[] args) {
		
        SavingAccount s1 = new SavingAccount();
        s1.AccountDetail();
        s1.savinginfo();
        System.out.println("--------------XXXXXXXXXXXXX--------------");
        FixDeposit s2 = new FixDeposit();
        s2.AccountDetail();
        s2.deposit();      
	}

}
