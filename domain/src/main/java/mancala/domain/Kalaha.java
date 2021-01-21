package mancala.domain;

public class Kalaha{
	int stones = 0;
	Player owner;
	Kalaha neighbour;

	Kalaha(){
		stones = 0;
	}
	
	Kalaha(Player owner, Kalaha neighbour){
		this.owner = owner;
		this.neighbour = neighbour;
	}
	
	public int getStones(){
		return stones;
	}
	
	public void addStones(int stones){
		this.stones += stones;
	}
	
	public void passStones(int stones){
		if(owner.isActivePlayer()){
			addStones(1);
			if(stones!=1){
				neighbour.passStones(stones-1);
			}
		}
	}
	
}