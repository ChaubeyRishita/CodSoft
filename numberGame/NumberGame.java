package numberGame;

import java.util.Random;

class GenerateNumber {
	public int generateNumber() {
		int number;
		Random random = new Random();
		number = random.nextInt(1, 101);
		return number;
	}
}

public class NumberGame {

	public char compareNumber(int number, int guess) {
		if (guess == number) {
			return 'C'; // correct guess
		} else if (guess < number) {
			return 'L'; // too low
		} else {
			return 'H'; // too high
		}
	}

}
