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
				getNeighbour().connectEndWith(this);
			}
		}
	}

	public Bowl getOpposite(){
		return (Bowl) getNeighbour().getOpposite().getNeighbour();
	}

	public Kalaha getOwnKalaha(){
		return getNeighbour().getOwnKalaha();
	}

	public Kalaha getOppKalaha(){
		return getOwnKalaha().getKalahaBySteps(7);
	}

	@Override
	public void passStones(int stonesAmount){
		addStones(1);
		if (stonesAmount!=1){
			getNeighbour().passStones(stonesAmount-1);
		}
		else{
			if (getOwner().isActivePlayer() && getStones() == 1){
				getOpposite().getStolen();
				getOwnKalaha().addStones(1);
				emptySelf();
			}
			getOwner().switchActivePlayer();
		}
	}

	protected void getStolen(){
		getOppKalaha().addStones(getStones());
		emptySelf();
	}

	public void startMove() throws Exception {
		if (getOwner().isActivePlayer()) {
			if (getStones()!=0) {
				int stonesToPass = getStones();
				emptySelf();
				getNeighbour().passStones(stonesToPass);
			}
			else {
				throw new Exception("Selected bowl is empty");
			}
		}
		else {
			throw new Exception("Selected bowl is not owned by the active player.");
		}
	}

	@Override
	protected boolean isRowEmpty() {
		if (getStones()!=0){
			return false;
		}
		return getNeighbour().isRowEmpty();
	}

	@Override
	protected void moveStonesToKalaha(int stoneAmount) {
		int stonesToMove = getStones();
		emptySelf();
		getNeighbour().moveStonesToKalaha(stoneAmount+stonesToMove);
	}
}