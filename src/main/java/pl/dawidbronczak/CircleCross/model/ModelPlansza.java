package pl.dawidbronczak.CircleCross.model;

import java.util.ArrayList;

public class ModelPlansza {
	private ArrayList<Character> fields;
	private int numberTurn = 1;
	private Player playerX;
	private Player playerO;
	private Player actualPlayer;
	
	public ModelPlansza(){
		playerPrepare();
	}

	public void prepare(){
		fields = new ArrayList<Character>();
		for(int i = 0;i<9;i++){
			fields.add(' ');	
			numberTurn = 1;
		}		
	}
	private void playerPrepare() {
		playerX = new Player("X");
		playerO = new Player("O");
		actualPlayer = playerX;
		playerX.getMyTurn().set(true);
	}
	
	public void setField(int index){
		fields.set(index, getSign());
	}

	public void nextPlayerTurn() {
		if(actualPlayer == playerX){
			actualPlayer = playerO;
			playerX.getMyTurn().set(false);
			
		}
		else {
			playerO.getMyTurn().set(false);
			actualPlayer = playerX;
		}			
		actualPlayer.getMyTurn().set(true);		
		numberTurn++;		
	}

	public ArrayList<Character> getFields() {
		return fields;
	}

	public Character getSign(){
		return actualPlayer.getSign().get().charAt(0);
	}				

	public boolean checkWin(){
		if(rowCheck()||columnCheck()||crossCheck())
			return true;
		return false;
	}
	public String getResult(){
		
		return "draw";
	}
	
	private boolean rowCheck(){
		for(int i=0;i<7;i=i+3){
			if(fields.get(i) != ' '){
				if((fields.get(i) == fields.get(i+1))&&(fields.get(i) == fields.get(i+2))){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean columnCheck(){
		for(int i = 0;i<3;i++){
			if(fields.get(i) != ' '){
				if((fields.get(i) == fields.get(i+3))&&(fields.get(i) == fields.get(i+6))){					
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean crossCheck(){
		if(fields.get(0) != ' '){
			if((fields.get(0) == fields.get(4))&&(fields.get(0) == fields.get(8))){
				return true;				
			}			
		}
		if(fields.get(2) != ' '){
			if((fields.get(2) == fields.get(4))&&(fields.get(2) == fields.get(6))){
				return true;
			}			
		}
		return false;
	}
	
	public Player getPlayerX() {
		return playerX;
	}
	public void setPlayerX(Player playerX) {
		this.playerX = playerX;
	}
	public Player getPlayerO() {
		return playerO;
	}
	public void setPlayerO(Player playerO) {
		this.playerO = playerO;
	}

	public Player getWinner() {
		return actualPlayer;
	}

	public void setPoints() {
		Player winner = getWinner();
		winner.getPoint().set(winner.getPoint().get()+1);
		
	}

	public Player getActualPlayer() {
		return actualPlayer;
	}

	public int getNumberTurn() {
		return numberTurn;
	}
	
}

