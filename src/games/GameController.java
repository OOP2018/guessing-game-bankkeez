package games;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GameController {
	@FXML
	private TextField guessbox;
	/** Sets the game */
	private NumberGame game;

	public void setGame(NumberGame game) {
		this.game = game;
	}

	public void onAction(ActionEvent event) {
		int guess;
		try {
			guess = Integer.parseInt(guessbox.getText().trim());
		} catch (NumberFormatException ex) {
			// guessbox.setText("Please input an integer guess");
			return;
		}
		boolean isCorrect = game.guess(guess);
		guessbox.setText("");
		if (isCorrect) {
			guessbox.setEditable(false);
		}

	}
}
