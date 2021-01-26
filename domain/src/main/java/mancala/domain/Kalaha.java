package mancala.domain;

public class Kalaha {
    private int stones;
    private Player owner;
    private Kalaha neighbour;

    Kalaha() {
    }

    Kalaha(int stones, Player owner, Kalaha neighbour) {
        this.stones = stones;
        this.neighbour = neighbour;
        this.owner = owner;
    }

    Kalaha(Player owner, Kalaha neighbour, int[] stoneList, int i) {
        this.stones = 0;
        this.owner = owner;
        this.neighbour = neighbour;
        new Bowl(owner, this, 6, stoneList, i + 1);
    }

    public void makeLoop() {
        makeLoop(new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    }

    // To construct a board with a specific setup: stoneList : int[]{A6 A5 A4 A3 A2 A1 B6 B5 B4 B3 B2 B1}
    public void makeLoop(int[] stoneList) {
        owner = new Player("Player A", "Player B");
        new Bowl(owner, this, 6, stoneList, 0);
    }

    public Kalaha getOwnKalaha() {
        return this;
    }

    public Kalaha getOpposite() {
        return this;
    }

    public Kalaha getNeighbour() {
        return neighbour;
    }

    public Player getOwner() {
        return owner;
    }

    public int getStones() {
        return stones;
    }

    public Kalaha getKalahaBySteps(int steps) {
        if (steps != 1) {
            return neighbour.getKalahaBySteps(steps - 1);
        }
        return neighbour;
    }

    protected void addStones(int stoneAmount) {
        stones += stoneAmount;
    }

    protected void passStones(int stonesPassed) {
        if (owner.isActivePlayer()) {
            addStones(1);
            if (stonesPassed != 1) {
                neighbour.passStones(stonesPassed - 1);
            }
        } else {
            neighbour.passStones(stonesPassed);
        }
    }

    protected void emptySelf() {
        stones = 0;
    }

    protected void connectEndWith(Kalaha kalaha) {
        if (neighbour == null) {
            neighbour = kalaha;
        } else {
            neighbour.connectEndWith(kalaha);
        }
    }
}