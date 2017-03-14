package pl.dawidbronczak.CircleCross.controller;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import pl.dawidbronczak.CircleCross.game.Main;

public class MainController {

    private static final URL GAME_VIEW_FXML = Main.class.getClass().getResource("/fxml/gameView.fxml");
	@FXML
    private BorderPane mainPane;
	
    private Pane boardGame;
    
    @FXML
    void initialize() throws IOException{  
    	showBoardGame();
    }

	private void showBoardGame() throws IOException {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(GAME_VIEW_FXML);
    	boardGame = loader.load();
    	mainPane.setCenter(boardGame);
	}    
}
