package interfaceATM;

public class BankAccount {
	private double accountBalance;
	private double minBalanceRequired;
	private double maxWithdrawalLimit;
	private double maxDepositLimit;

//	 	Constructor: sets the account balance of that particular account to initial balance initially
	public BankAccount(double initialBalance, double minBalanceRequired, double maxWithdrawalLimit,
			double maxDepositLimit) {
		this.accountBalance = initialBalance;
		this.minBalanceRequired = minBalanceRequired;
		this.maxWithdrawalLimit = maxWithdrawalLimit;
		this.maxDepositLimit = maxDepositLimit;
	}

	public double getBalance() {
		return accountBalance;
	}

	public void withdraw(double amount) {
		if (amount > maxWithdrawalLimit) {
			System.out.println("You cannot withdraw more than " + maxWithdrawalLimit
					+ " at once. Try again with a lower amount.");
		} else if (amount > accountBalance) {
			System.out.println("Insufficient balance. Try again with a lower amount.");
		}else if((accountBalance - amount) < minBalanceRequired){
			System.out.println("Account should have minimum balance of Rs." + minBalanceRequired + " after withdrawal. Try again with a lower amount.");
		}
		else {
			accountBalance -= amount;
			System.out.println("Transaction successful.");
		}
	}

	public void deposit(double amount) {
		if (amount > maxDepositLimit) {
			System.out.println(
					"You cannot deposit more than " + maxDepositLimit + " at once. Try again with a lower amount.");
		} else {
			accountBalance += amount;
			System.out.println("Transaction successful.");
		}
	}
}
