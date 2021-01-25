package mancala.domain;

public class Player{
	private String name;
	private boolean isActivePlayer;
	private Player opponent;

	Player(String name, String opponentName){
		this.name = name;
		setOpponent(new Player(opponentName));
		setActivePlayer();
	}

	private Player(String name){
		this.name = name;
	}


	private void setOpponent(Player opponent){
		this.opponent = opponent;
		opponent.opponent = this;
	}

	public Player getOpponent(){
		return opponent;
	}

	public String getName(){
		return name;
	}

	public boolean isActivePlayer(){
		return isActivePlayer;
	}

	private void setActivePlayer(){
		isActivePlayer = true;
		opponent.isActivePlayer = false;
	}

	public void switchActivePlayer(){
		if (isActivePlayer){
			opponent.setActivePlayer();
		}
		else{
			setActivePlayer();
		}
	}
}