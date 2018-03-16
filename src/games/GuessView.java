package games;

import java.util.Observable;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class GuessView implements java.util.Observer {
	/** the stage for showing scene */
	private Stage stage;
	/** A game to play */
	private NumberGame game;
	/** the label that shows the game message */
	private Label label;
	
	/**
	 * Initialize a GameDisplay, which shows message of the game.
	 * @param Any NumberGame
	 */
	public GuessView(NumberGame game) {
		this.game = game;
		initComponents();
	}
	
	private void initComponents() {
		stage = new Stage();
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		label = new Label("   ");
		label.setPrefSize(400, 200);
		label.setFont(new Font("Arial", 20.0));
		label.setAlignment(Pos.CENTER);
		root.getChildren().add(label);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		//stage.setTitle("Count");
		stage.sizeToScene();
	}
	
	/** Show the window and update the game message. */
	public void run() {
		stage.show();
		display();
	}
	
	public void display() {
		label.setText( String.format("%s", game.getMessage()) );
	}

	@Override
	public void update(Observable o, Object arg) {
		display();
	}	
}
