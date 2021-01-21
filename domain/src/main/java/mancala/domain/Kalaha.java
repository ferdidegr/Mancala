package mancala.domain;

public class Kalaha{
	int stones = 4;
	Bowl neighbour;
	Player owner;
	
	
	
	public int getStones(){
		return stones;
	}
	
	public void addStones(int stones){
		this.stones += stones;
	}
	
	public void passStones(int stones) throws NullPointerException{
		if (neighbour == null){
			throw new NullPointerException("No known neighbour!");
		}
		
		if(owner.isActivePlayer()){
			addStones(1);
			if(stones!=1){
				neighbour.passStones(stones-1);
			}
		}
	}
	
}