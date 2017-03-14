package pl.dawidbronczak.CircleCross.controller;

import java.io.InputStream;
import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import pl.dawidbronczak.CircleCross.game.Main;
import pl.dawidbronczak.CircleCross.model.ModelPlansza;

public class GameViewController {
	private static final InputStream IMG_X = Main.class.getClass().getResourceAsStream("/img/X.png");
	private static final InputStream IMG_O = Main.class.getClass().getResourceAsStream("/img/O.png");
    
    @FXML
    private Button start;
    
    @FXML
    private GridPane board;
    
    @FXML
    private Label playerXName;

    @FXML
    private Label playerXPoints;

    @FXML
    private Label playerOName;

    @FXML
    private Label playerOPoints;
    
    @FXML
    private Circle playerXTurn;

    @FXML
    private Circle playerOTurn;
    
    private ObservableList<Node> fieldButtons;
    private Image imgX = new Image(IMG_X);
    private Image imgO = new Image(IMG_O);
    private ModelPlansza model = new ModelPlansza();
    
    @FXML
    void initialize(){
    	bindProperties();
    	fieldButtons = board.getChildren();
    	board.setDisable(true);
    	  	for(Node field : fieldButtons){ 		
    	  		if(field instanceof ToggleButton){
    	  			ToggleButton actualButton = (ToggleButton) field;
    	  			actualButton.setGraphic(new ImageView(imgX));
    		}
    	}
    }
   
    @FXML
    public void startGame(){
    	setPlayersName();    	
    	start.setDisable(true);
    	board.setDisable(false);
    	prepareBoard();
    	model.prepare();
    }
    
    @FXML
    public void clicked(ActionEvent event){
     	ToggleButton source = (ToggleButton) event.getSource();  	
    	if(model.getActualPlayer()==model.getPlayerX())
    		source.setGraphic(new ImageView(imgX));
    	else
    		source.setGraphic(new ImageView(imgO));
    	source.setDisable(true); 
    	model.setField(fieldButtons.indexOf(source));     	
    	if(model.checkWin()){		
    		gameEnd();
    	}
    	else if(model.getNumberTurn()>8){
    		gameDraw();
    	}
    	else
    		model.nextPlayerTurn();
    }
	
    private void gameDraw() {
		board.setDisable(true);
		start.setDisable(false);
		DialogWindows.gameEndAlert();		
	}
    
	private void gameEnd() {
		board.setDisable(true);
		start.setDisable(false);
		DialogWindows.gameEndAlert(model.getWinner());
		model.setPoints();		
	}
	
	@SuppressWarnings("unchecked")
	private void bindProperties() {
		playerXName.textProperty().bind(model.getPlayerX().getName());
    	playerOName.textProperty().bind(model.getPlayerO().getName());
    	
    	@SuppressWarnings("rawtypes")
		StringConverter converter = new NumberStringConverter();
    	playerXPoints.textProperty().bindBidirectional(model.getPlayerX().getPoint(),converter);
    	playerOPoints.textProperty().bindBidirectional(model.getPlayerO().getPoint(), converter);
    	
    	playerXTurn.visibleProperty().bind(model.getPlayerX().getMyTurn());
    	playerOTurn.visibleProperty().bind(model.getPlayerO().getMyTurn());
	}
    
	private void setPlayersName() {
		if(model.getPlayerX().getName().get() == null){    		
    		Optional<String> result = DialogWindows.playerNameDialog('X');
    		model.getPlayerX().getName().set(result.get());
    	}
    	if(model.getPlayerO().getName().get() == null){
    		Optional<String> result = DialogWindows.playerNameDialog('O');
    		model.getPlayerO().getName().set(result.get());
    	}
	}
   
	private void prepareBoard(){
    	for(Node field : fieldButtons){ 		
	  		if(field instanceof ToggleButton){
	  			ToggleButton actualButton = (ToggleButton) field;
	  			actualButton.setGraphic(null);
	  			actualButton.setSelected(false);
	  			actualButton.setDisable(false);
	  			
	  		}    	
    	}
    }
 }
