import java.util.Random;;

/**
 * Bank's guessing game, quite tricky.
 * 
 * @author Piyawat Setthitikun
 */
public class BanksGame extends NumberGame {
	private int upperbound;
	private int secret;
	private int count;

	/**
	 * Initialize a new game.
	 * 
	 * @param upperbound
	 *            is the max of the number which is more than 1.
	 */
	public BanksGame(int upperbound) {
		this.upperbound = upperbound;
		long seed = System.nanoTime();
		Random random = new Random(seed);
		this.secret = random.nextInt(upperbound) + 1;
		super.setMessage("I'm thinking of a number between 1 and " + upperbound);
	}

	/**
	 * Evaluate a user's guess.
	 * 
	 * @param number
	 *            is the user's guess
	 * @return true if guess is correct or false if wrong.
	 */
	@Override
	public boolean guess(int number) {
		count++;
		if (number == this.secret) {
			super.setMessage("Hooray! That is the correct number.");
			return true;
		}
		if (number < secret) {
			super.setMessage("too small");
		} else if (number > secret) {
			super.setMessage("too large");
		}
		return false;
	}

	/**
	 * Get count value which comes guess(int number)
	 * 
	 * @return count
	 */
	@Override
	public int getCount() {
		return count;
	}

	/** Get the game upper bound. */
	public int getUpperBound() {
		return this.upperbound;
	}

	@Override
	public String toString() {
		return String.format("Guees a secret number between 1 and %d", this.upperbound);

	}
}
