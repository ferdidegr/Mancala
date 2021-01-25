package mancala.domain;

public class Kalaha{
	int stones = 0;
	private Player owner;
	Kalaha neighbour;

	Kalaha(){}

	Kalaha(int stones, Player owner, Kalaha neighbour){
		this.stones = stones;
		this.neighbour = neighbour;
		this.owner = owner;
	}

	Kalaha(Player owner, Kalaha neighbour, int[] stoneList, int i){
		this.owner = owner;
		this.neighbour = neighbour;
		new Bowl(owner,this,6, stoneList, i+1);
	}

	public void makeLoop(){
		makeLoop(new int[]{4,4,4,4,4,4,4,4,4,4,4,4});
	}

	public void makeLoop(int[] stoneList){
		owner = new Player("Player A","Player B");
		new Bowl(owner,this,6, stoneList, 0);
	}

	public Player getOwner(){
		return owner;
	}

	public Kalaha getKalahaBySteps(int steps){
		if (steps != 1) {
			return neighbour.getKalahaBySteps(steps-1);
		}
		return neighbour;
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

	public Kalaha getOwnKalaha() {
		return this;
	}

	public Kalaha getOpposite() {
		return this;
	}

	public Kalaha getNeighbour(){
		return neighbour;
	}

	public void connectEndWith(Kalaha kalaha){
		if (neighbour == null){
			neighbour = kalaha;
		}
		else{
			neighbour.connectEndWith(kalaha);
		}
	}
}