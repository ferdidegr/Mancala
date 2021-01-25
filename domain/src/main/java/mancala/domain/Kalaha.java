package mancala.domain;

public class Kalaha{
	int stones = 0;
	Player owner;
	Kalaha neighbour;

	Kalaha(){

	}

	Kalaha(Player owner,Kalaha neighbour){
		this.owner = owner;
		this.neighbour = neighbour;
		new Bowl(owner,this,6);
	}

	public void makeLoop(){
		owner = new Player("Player A","Player B");
		new Bowl(owner,this,6);
	}

	public Kalaha copy(){
		Kalaha copy = new Kalaha();
		copy.owner = owner;
		copy.neighbour = neighbour;
		copy.stones = stones;
		return copy;
	}

	public Kalaha getKalahaBySteps(int steps){
		Kalaha referencePoint = this.copy();
		for (int i=0;i<steps;i++){
			referencePoint = referencePoint.neighbour;
		}
		return referencePoint;
	}

	public void addStones(int stoneAmount){
		stones += stoneAmount;
	}

	public void passStones(int stonesPassed){
		if(owner.isActivePlayer()){
			addStones(1);
			if (stonesPassed!=1){
				neighbour.passStones(stonesPassed-1);
			}
		}
		else{
			neighbour.passStones(stonesPassed);
		}
	}
	
}