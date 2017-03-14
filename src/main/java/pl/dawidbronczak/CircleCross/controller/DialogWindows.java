package pl.dawidbronczak.CircleCross.controller;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import pl.dawidbronczak.CircleCross.model.Player;

public class DialogWindows {
	public static void gameEndAlert(Player winner){
		Alert gameEnd = new Alert(AlertType.INFORMATION);
		gameEnd.setTitle("Koniec gry!");
		gameEnd.setGraphic(null);
		gameEnd.setHeaderText(null);
		gameEnd.setContentText("Wygra³ gracz - "+winner.getName().get());
		gameEnd.showAndWait();
	}
	public static Optional<String> playerNameDialog(char c){
		TextInputDialog playerName = new TextInputDialog();	
		playerName.getDialogPane().getButtonTypes().remove(1);
		playerName.setTitle(null);
		playerName.setHeaderText(null);
		playerName.setGraphic(null);
		playerName.setContentText("Podaj nazwe gracza "+c+" :");	
		return 	playerName.showAndWait();
	}
	public static void gameEndAlert() {
		Alert gameEnd = new Alert(AlertType.INFORMATION);
		gameEnd.setTitle("Koniec gry!");
		gameEnd.setGraphic(null);
		gameEnd.setHeaderText(null);
		gameEnd.setContentText("Remis!");
		gameEnd.showAndWait();
	}
}
