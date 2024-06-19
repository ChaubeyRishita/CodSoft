package interfaceATM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		double initialBalance = 50000.00;
		double minBalanceRequired = 1000.00;
		double maxWithdrawalLimit = 50000.00;
		double maxDepositLimit = 200000.00;
		BankAccount account = new BankAccount(initialBalance, minBalanceRequired, maxWithdrawalLimit, maxDepositLimit);
		InterfaceATM ATM = new InterfaceATM(account);
		Scanner sc = new Scanner(System.in);

		while (true) {
			ATM.displayOptions();

			int choice;
//			only handle the case for non-integer input.
//			invalid integer input handled by default case.
			while (!sc.hasNextInt()) { // Check for valid integer input
				System.out.println("Invalid input. Please enter an integer. ");
				ATM.displayOptions();
				sc.next(); // Clear the buffer
			}
			choice = sc.nextInt();
			if (choice == 4) { 
				System.out.println("Thank you for using ATM. Goodbye!");
				break;
			}

			ATM.performTransaction(choice);
		}
		sc.close();
	}
}
