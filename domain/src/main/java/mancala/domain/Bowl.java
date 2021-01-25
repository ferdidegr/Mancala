package mancala.domain;

public class Bowl extends Kalaha{

	Bowl(Player owner, Kalaha neighbour, int n){
		this.stones = 4;
		this.owner=owner;
		this.neighbour=neighbour;

		// Make another bowl if not the last one
		if (n!=1){
			new Bowl(owner,this,n-1);
		}
		// Last bowl, so make Kalaha if active player, or find the existing kalaha and make connection
		else{
			if (owner.isActivePlayer()){
				new Kalaha(owner.opponent,this);
			}
			else{
				//Find start of chain, make connection to this bowl
				Kalaha originOfChain = this.copy();
				while (originOfChain.neighbour!=null){
					originOfChain = originOfChain.neighbour;
				}
				originOfChain.neighbour = this;
			}
		}
	}

	public Kalaha getOpposite(){
		Kalaha ref = this.copy();
		int steps = 0;
		do{
			ref = ref.neighbour;
			steps++;
		}
		while(ref instanceof Bowl);
		ref = ref.getKalahaBySteps(steps);
		return ref;
	}

	public Kalaha getOwnKalaha(){
		Kalaha ref = this.copy();
		do{
			ref = ref.neighbour;
		}
		while(ref instanceof Bowl);
		return ref;
	}

	public Kalaha getOppKalaha(){
		Kalaha ref = getOwnKalaha();
		ref = ref.getKalahaBySteps(7);
		return ref;
	}

	public void passStones(int stonesAmount){
		addStones(1);
		if (stonesAmount!=1){
			neighbour.passStones(stonesAmount-1);
		}
		else{
			if (owner.isActivePlayer()){
				//steal
			}
			owner.switchActivePlayer();
		}
	}
}