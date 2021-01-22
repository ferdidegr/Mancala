package mancala.domain;

public class Bowl extends Kalaha{
	Bowl opposite;

	// Constructor for first row of bowls
	Bowl(Kalaha oppNeighbour, int n){
		stones = 4;
		owner = oppNeighbour.owner.opponent;
		//make opposite bowl
		opposite = new Bowl(this, oppNeighbour);
		//make neighbour
		if (n == 6) {
			// special case: neighbour is Kalaha
			neighbour = new Kalaha(owner,opposite);
		}
		else{
			//make next bowl
			neighbour = new Bowl(opposite,n+1);
		}
	}

	// Constructor for an opposite bowl of the first row
	Bowl(Bowl opposite, Kalaha neighbour){
		stones = 4;
		this.opposite = opposite;
		this.neighbour = neighbour;
		this.owner = neighbour.owner;
	}

	public void startMove() throws Exception{
		if (owner.isActivePlayer()){
			if (getStones() != 0) {
				int amountToPass = getStones();
				emptySelf();
				neighbour.passStones(amountToPass);
			}
			else{
				throw new Exception("Cannot select an empty bowl!");
			}
		}
		else{
			throw new Exception("Must select a bowl of the active player!");
		}
	}



	public void passStones(int stones){
		addStones(1);
		if (stones!=1){
			neighbour.passStones(stones-1);
		}
		else{
			if (owner.isActivePlayer()){
				steal();
			}
			owner.switchActivePlayer();
		}
	}

	public void steal(){
		opposite.donateStonesToOpposite();
		int totalToAdd = stones;
		emptySelf();
		owner.kalaha.addStones(totalToAdd);
	}

	public void donateStonesToOpposite(){
		opposite.addStones(stones);
		emptySelf();
	}

	public void emptySelf(){
		stones = 0;
	}

}