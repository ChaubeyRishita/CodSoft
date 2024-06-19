package numberGame;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int score = 0, maxRounds = 3, currentRound = 1;
		Scanner sc = new Scanner(System.in);

//		Rounds iteration
		while (currentRound <= maxRounds) {
			System.out.println("Round " + currentRound + " of " + maxRounds + ": \n");

			GenerateNumber n = new GenerateNumber();
			int number = n.generateNumber();
			int maxAttempts = 3, currentAttempt = 1;

//			Attempts iteration
			while (currentAttempt <= maxAttempts) {
				System.out.println("Attempt " + currentAttempt + " of Round " + currentRound +": \n");
//				A valid attempt is counted only on a valid integer(1 to 100).

//				Error handling to ensure entered value is an integer between 1 to 100.
				int guess;
				do {
					System.out.println("Enter your guess (any integer from 1 to 100): ");
					while (!sc.hasNextInt()) { // Check for valid integer input
//						Does not move ahead until a valid integer is input
						System.out.println("Invalid input. Please enter an integer. ");
						sc.next(); // Clear the buffer 
					}
					guess = sc.nextInt();
					if(guess < 1 || guess > 100) {
						System.out.println("Your entered number was out of range.");
					}
				} while (guess < 1 || guess > 100);

				NumberGame game = new NumberGame();
				char verdict = game.compareNumber(number, guess);

//				Result for the particular attempt
				if (verdict == 'C') {
					System.out.println("Your guess is correct.\nYou win!");
					score += 1;
					break; // breaks attempt loop. Thus ends the current round.
				} else if (verdict == 'L') {
					System.out.println("Your guessed number is too low.\nTry again!");
				} else {
					System.out.println("Your guessed number is too high.\nTry again!");
				}
				currentAttempt += 1;	
			}

			if (currentAttempt == maxAttempts + 1) {
				System.out.println("You Lose!");
			}
			currentRound += 1;
		}
		sc.close();

//		Final Score
		System.out.println("Your final score is " + score + ".");

	}
}
