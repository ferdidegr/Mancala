package mancala.domain;

public class Bowl extends Kalaha{
	Bowl opposite;

	Bowl(){
		super();
	}

	// Constructor for first row of bowls
	Bowl(Kalaha oppNeighbour, int n){
		stones = 4;
		owner = oppNeighbour.owner.opponent;
		//make opposite bowl
		opposite = new Bowl(this, oppNeighbour);
		//make neighbour
		if (n == 6) {
			// special case: neighbour is Kalaha
			neighbour = new Kalaha(null,opposite);
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



}