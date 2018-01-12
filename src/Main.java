/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new BanksGame(upperBound);
		GameSolver ai = new GameSolver( );
		int solution = ai.play( game );
		System.out.println("play() returned "+solution);
		System.out.println("guess() returned "+game.getCount());
	}
}
