/**
 * Finds the secret number in one click.
 */
public class GameSolver {
	/**
	 * Play a NumberGame and return the secret number. The NumberGame object
	 * must provide messages (getMessage) containing the phrase "too small" or
	 * "too large"
	 * 
	 * @author Piyawat Setthtikun
	 * 
	 * @param game
	 *            is the NumberGame to solve @ return the secret number
	 */
	public int play(NumberGame game) {
		// describe the game
		System.out.println(game);
		int max = game.getUpperBound();
		int min = 0;
		int find = (max - min) / 2;
		int count = 0;
		while (true) {
			System.out.println(game.getMessage());
			System.out.println("AI answer? " + find);
			boolean correct = game.guess(find);
			if (game.getMessage().contains("too large")) {
				max = find;
				find = find - ((max - min) / 2);
			} else if (game.getMessage().contains("too small")) {
				min = find;
				find = ((max - min) / 2) + find;
			}
			if (correct)
				return find;
		}
	}
}
