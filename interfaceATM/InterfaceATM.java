package interfaceATM;

import java.util.Scanner;

public class InterfaceATM {
	private BankAccount account;

	// Constructor: sets the value of account for that particular session to a
	// particular account and shows the transaction on the ATM is taking place for
	// that account, technically after inserting the card.
	public InterfaceATM(BankAccount account) {
		this.account = account;
	}

	public void displayOptions() {
		System.out.println("Welcome to ATM");
		System.out.println("1. Withdrawal");
		System.out.println("2. Deposit");
		System.out.println("3. Check Balance");
		System.out.println("4. Exit");
		System.out.println("Enter your choice: ");
	}
	
//	function for exception handling in case of user input for withdraw and deposit amounts.
	public static double getValidAmount(Scanner sc, String message) {
	    double amount;
	    while (true) {
	        System.out.println(message);
	        if (sc.hasNextDouble()) {
	            amount = sc.nextDouble();
	            if (amount % 100 == 0 && amount > 0) { // Check for multiple of 100 and positive value
	                return amount;
	            } else {
	                System.out.println("Invalid amount. Please enter a multiple of 100 and a positive value.");
	            }
	        } else {
	            System.out.println("Invalid input. Please enter a numerical value.");
	            sc.next(); // Clear buffer and consume invalid input
	        }
	    }
	}

	public void performTransaction(int choice) {
		Scanner sc = new Scanner(System.in);
		switch (choice) {
		case 1:
			double withdrawAmount = getValidAmount(sc, "Enter amount to withdraw (multiple of 100): ");
			account.withdraw(withdrawAmount);
			break;
		case 2:
			double depositAmount = getValidAmount(sc, "Enter amount to deposit (multiple of 100): ");
			account.deposit(depositAmount);
			break;
		case 3:
			System.out.println("Your account balance is Rs." + account.getBalance() + ".");
			break;
		case 4:
			break;
		default:
			System.out.println("Invalid choice. Please try again.");
		}
	}

}
