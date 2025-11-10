package lab6bank;

public class CheckingAccount extends BankAccount {
	//Variables
	private static final double FEE = 0.15;
	
	
	//Constructor
	public CheckingAccount(String name, double amount) {
		super(name, amount);
		
		String newAcc = getAccountNumber() + "-10";
		setAccountNumber(newAcc);
	}
	
	
	@Override
	public boolean withdraw(double amount) {
		double total = amount+FEE;
		
		return super.withdraw(total);
	}
	
	
	
	
	
	
}
