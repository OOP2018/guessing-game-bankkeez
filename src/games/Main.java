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
			FXMLLoader loader = new FXMLLoader(url);
			// create scene graph from file
			Parent root = loader.load();
			// get the controller for the scene
			GameController controller = loader.getController();
			// Dependency Injection:
			// set the game into the controller
			controller.setGame(game);
			// show the scene
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.show();
		} catch (Exception e) {
			System.out.println("Exception create in scene: " + e.getMessage());
			e.printStackTrace();
		}
		// add observer that displays guess messages
		GuessView view = new GuessView(game);
		// register view to observable
		game.addObserver(view);
		// display the game's messager scene
		view.run();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
