package pl.dawidbronczak.CircleCross.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {
	private StringProperty name;
	private IntegerProperty points;
	private StringProperty sign;
	private BooleanProperty myTurn;
	
	public Player(String sign){
		name = new SimpleStringProperty();
		points = new SimpleIntegerProperty();
		this.sign = new SimpleStringProperty(sign);
		setMyTurn(new SimpleBooleanProperty());
	}
	public StringProperty getName() {
		return name;
	}
	public void setName(StringProperty name) {
		this.name = name;
	}
	public IntegerProperty getPoint() {
		return points;
	}
	public void setPoint(IntegerProperty point) {
		this.points = point;
	}
	public StringProperty getSign() {
		return sign;
	}
	public void setSign(StringProperty sign) {
		this.sign = sign;
	}
	public BooleanProperty getMyTurn() {
		return myTurn;
	}
	public void setMyTurn(BooleanProperty myTurn) {
		this.myTurn = myTurn;
	}
	 
}
