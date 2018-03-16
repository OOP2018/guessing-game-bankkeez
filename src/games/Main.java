package games;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A main class for the GuessingGame. It is responsible for creating objects,
 * connecting objects, and running the game UI.
 */
public class Main extends Application {

	@Override
	public void start(Stage stage) {
		// Create the game object
		int upperBound = 100;
		NumberGame game = new BanksGame(upperBound);
		// create the game to play
		try {
			String fxmlfile = "GameUI.fxml";
			URL url = getClass().getResource(fxmlfile);
			if (url == null) {
				System.out.println("Could not find resource for " + fxmlfile);
				return;
			}
			// Load the FXML and get reference to the loader
			FXMLLoader loader = new FXMLLoader(url);
			// Create scene graph from file (UI)
			Parent root = loader.load();
			// Get the controller for the scene
			GameController controller = loader.getController();

			// Dependency Injection:
			// Set the game into the controller
			controller.setGame(game);
			// Show the scene
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.setTitle("Let's Guess!");
			stage.show();
		} catch (Exception e) {
			System.out.println("Exception create in scene: " + e.getMessage());
			e.printStackTrace();
		}
		// Add observer that displays game message
		GuessView view = new GuessView(game);
		CountView view2 = new CountView(game);
		// Register each view to observable
		game.addObserver(view);
		game.addObserver(view2);
		// Display the game message scene
		view.run();
		view2.run();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
