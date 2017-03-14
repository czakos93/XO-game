package pl.dawidbronczak.CircleCross.game;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{

	private static final URL MAIN_VIEW_FXML = Main.class.getClass().getResource("/fxml/mainView.fxml");

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MAIN_VIEW_FXML);
		
		
		BorderPane mainPane = (BorderPane) loader.load();
		Scene scene = new Scene(mainPane);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Gra w Kó³ko i Krzy¿yk");
		primaryStage.show();
	}

}
