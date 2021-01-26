package mancala.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BowlTest {

    Kalaha kalahaA = new Kalaha();
    Player playerA = new Player("Player A","Player B");
    Bowl B1;
    Bowl A1;

    @BeforeEach
    public void init(){
        kalahaA.makeLoop();
        B1 = (Bowl)kalahaA.getKalahaBySteps(1);
        A1 = (Bowl)kalahaA.getKalahaBySteps(8);
    }

    @Test
    public void newBowlButNotLast(){
        Bowl testbowl = new Bowl(playerA,null,3,new int[]{4,4,4,4,4,4,4,4,4,4,4,4},0);
        assertTrue(testbowl.getNeighbour() instanceof Bowl);
    }

    @Test
    public void lastTwoBowlsAndNotActivePlayerSoCloseLoop(){
        Bowl testbowl = new Bowl(playerA.getOpponent(),null,2,new int[]{4,4,4,4,4,4,4,4,4,4,4,4},0);
        assertEquals(testbowl,testbowl.getKalahaBySteps(2));
    }

    @Test
    public void lastBowlAndActivePlayerSoNewKalaha(){
        Bowl testbowl = new Bowl(playerA,null,1,new int[]{4,4,4,4,4,4,4,4,4,4,4,4},0);
        assertFalse(testbowl.getKalahaBySteps(7) instanceof Bowl);
    }

    @Test
    public void findOppositeForA1(){
        assertEquals(A1.getOpposite(),A1.getKalahaBySteps(12));
    }

    @Test
    public void getOwnKalaha(){
        assertEquals(A1.getOwnKalaha(),kalahaA);
    }

    @Test
    public void getOppKalaha(){
        assertEquals(B1.getOppKalaha(),kalahaA);
    }

    @Test
    public void passStonesAddsOne(){
        kalahaA.getNeighbour().passStones(1);
        assertEquals(5,kalahaA.getNeighbour().getStones());
    }

    @Test
    public void passStonesSwitchesPlayer(){
        kalahaA.getNeighbour().passStones(1);
        assertFalse(kalahaA.getOwner().isActivePlayer());
    }

    @Test
    public void emptySelf(){
        B1.emptySelf();
        assertEquals(0,kalahaA.getNeighbour().getStones());
    }

    @Test
    public void getStolenIsEmpty(){
        B1.getStolen();
        assertEquals(0,B1.getStones());
    }

    @Test
    public void getStolenAddedToOppKalaha(){
        B1.getStolen();
        assertEquals(4,kalahaA.getStones());
    }

    @Test
    public void startMoveButNotActivePlayer(){
        assertThrows(Exception.class, () -> B1.startMove());
    }

    @Test
    public void startMoveWith14EndWith1() throws Exception{
        Kalaha testK = new Kalaha();
        testK.makeLoop(new int[]{4,4,4,4,4,14,4,4,4,4,4,4});
        A1 = (Bowl)testK.getKalahaBySteps(8);
        A1.startMove();
        assertEquals(1,A1.getStones());
    }

    @Test
    public void startMoveWith13EndWith0() throws Exception{
        Kalaha testK = new Kalaha();
        testK.makeLoop(new int[]{4,4,4,4,4,13,4,4,4,4,4,4});
        A1 = (Bowl)testK.getKalahaBySteps(8);
        A1.startMove();
        assertEquals(0,A1.getStones());
    }



}