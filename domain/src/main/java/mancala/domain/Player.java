package mancala.domain;

public class Player{
String name;
private boolean ActivePlayer;
Player opponent;
Kalaha kalaha;

Player(String name){
	this.name = name;
}

public void setOpponent(Player opponent){
	this.opponent = opponent;
	opponent.opponent = this;
}

public boolean isActivePlayer(){
	return ActivePlayer;
}

public void setActivePlayer(){
	ActivePlayer = true;
	opponent.ActivePlayer = false;
}





}