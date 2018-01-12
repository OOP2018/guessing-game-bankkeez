import java.util.Scanner;

/**
 * Play guessing game on the console.
 */
public class GameConsole {

	/** The play method plays a game using input from a user.
	 * @param recieve NumberGame object
	 * @return the correct number
	 */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);

		// describe the game
		System.out.println(game);

		while (true) {
			System.out.println(game.getMessage());
			System.out.print("Your answer? ");
			int guess = console.nextInt();
			boolean correct = game.guess(guess);
			// System.out.println(game.getMessage());
			if (correct)
				return guess;
		}
	}

}
