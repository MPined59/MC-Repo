package lab6bank;

public class SavingsAccount extends BankAccount{
	//Variables
	private double rate = 0.025;
	private int savingsNumber = 0;
	
	private String accountNumber;
	
	//Constructors
	public SavingsAccount(String name, double amount) {
		super(name, amount);
		
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	public SavingsAccount(SavingsAccount oldAccount, double amount) {
		super(oldAccount, amount);
		
		this.savingsNumber = oldAccount.savingsNumber + 1;
		this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
	}
	
	//Methods
	public void postInterest() {
		double interest = getBalance() * rate/12;
		deposit(interest);
	}
	
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}

}
