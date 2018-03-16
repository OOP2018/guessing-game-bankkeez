package games;

import java.util.Observable;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * A Controller for a window that displays the count of guesses.
 * 
 * @author Piyawat Setthitikun
 *
 */
public class CountView implements java.util.Observer {
	/** the stage for showing scene */
	private Stage stage;
	/** A game to play */
	private NumberGame game;
	/** the label that shows the game message */
	private Label label;

	/**
	 * Initialize the count of the game display, which show guesses of the game.
	 * 
	 * @param Any
	 *            NumberGame
	 */
	public CountView(NumberGame game) {
		this.game = game;
		initComponents();
	}

	private void initComponents() {
		stage = new Stage();
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		label = new Label("   ");
		label.setPrefSize(300, 150);
		label.setFont(new Font("Arial", 70.0));
		label.setAlignment(Pos.CENTER);
		root.getChildren().add(label);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Guess");
		stage.sizeToScene();
	}

	/** Show the window and update the game message. */
	public void run() {
		stage.show();
		display();
	}

	public void display() {
		label.setText(String.format("%2d", game.getCount()));
	}

	@Override
	public void update(Observable o, Object arg) {
		display();
	}
}
