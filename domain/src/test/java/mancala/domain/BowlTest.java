package mancala.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BowlTest {

    Kalaha kalahaA = new Kalaha();
    Player playerA = new Player("Player A","Player B");

    @BeforeEach
    public void init(){
        kalahaA.makeLoop();
    }

    @Test
    public void newBowlButNotLast(){
        Bowl testbowl = new Bowl(playerA,null,3);
        assertTrue(testbowl.neighbour instanceof Bowl);
    }

    @Test
    public void lastTwoBowlsAndNotActivePlayerSoCloseLoop(){
        Bowl testbowl = new Bowl(playerA.opponent,null,2);
        assertEquals(testbowl,testbowl.getKalahaBySteps(2));
    }

    @Test
    public void lastBowlAndActivePlayerSoNewKalaha(){
        Bowl testbowl = new Bowl(playerA,null,1);
        assertFalse(testbowl.getKalahaBySteps(7) instanceof Bowl);
    }

    @Test
    public void findOppositeForA1(){
        Bowl A1 = (Bowl)kalahaA.getKalahaBySteps(8);
        assertEquals(A1.getOpposite(),A1.getKalahaBySteps(12));
    }

    @Test
    public void getOwnKalaha(){
        Bowl A1 = (Bowl)kalahaA.getKalahaBySteps(8);
        assertEquals(A1.getOwnKalaha(),kalahaA);
    }

    @Test
    public void getOppKalaha(){
        Bowl B1 = (Bowl)kalahaA.getKalahaBySteps(1);
        assertEquals(B1.getOppKalaha(),kalahaA);
    }

    @Test
    public void passStonesAddsOne(){
        kalahaA.neighbour.passStones(1);
        assertEquals(5,kalahaA.neighbour.stones);
    }

    @Test
    public void passStonesSwitchesPlayer(){
        kalahaA.neighbour.passStones(1);
        assertFalse(kalahaA.owner.isActivePlayer());
    }

}