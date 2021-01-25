package mancala.domain;

public class Bowl extends Kalaha{

	Bowl(Player owner, Kalaha neighbour, int n, int[] stoneList, int i){
		super(stoneList[i],owner,neighbour);

		// Make another bowl if not the last one
		if (n!=1){
			new Bowl(owner,this,n-1, stoneList, i+1);
		}
		// Last bowl, so make Kalaha if active player, or find the existing kalaha and make connection
		else{
			if (owner.isActivePlayer()){
				new Kalaha(owner.getOpponent(), this, stoneList, i);
			}
			else{
				//Find start of chain, make connection to this
				neighbour.connectEndWith(this);
			}
		}
	}

	public Bowl getOpposite(){
		return (Bowl) neighbour.getOpposite().getNeighbour();
	}

	public Kalaha getOwnKalaha(){
		return neighbour.getOwnKalaha();
	}

	public Kalaha getOppKalaha(){
		return getOwnKalaha().getKalahaBySteps(7);
	}

	public void passStones(int stonesAmount){
		addStones(1);
		if (stonesAmount!=1){
			neighbour.passStones(stonesAmount-1);
		}
		else{
			if (getOwner().isActivePlayer() && stones == 1){
				getOpposite().getStolen();
				getOwnKalaha().addStones(1);
				emptySelf();
			}
			getOwner().switchActivePlayer();
		}
	}

	public void emptySelf(){
		stones = 0;
	}

	public void getStolen(){
		getOppKalaha().addStones(stones);
		emptySelf();
	}

	public void startMove() throws Exception {
		if (getOwner().isActivePlayer()) {
			int stonesToPass = stones;
			emptySelf();
			neighbour.passStones(stonesToPass);
		}
		else {
			throw new Exception("Selected bowl is not owned by the active player.");
		}
	}
}