package mancala.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KalahaTest {

    Kalaha kalahaA = new Kalaha();

    @BeforeEach
    public void init(){
        kalahaA.makeLoop();
    }

    @Test
    public void testCopy(){
        Kalaha kalahaB = kalahaA.copy();
        assertNotSame(kalahaA, kalahaB);
        assertEquals(kalahaA.neighbour,kalahaB.neighbour);
    }

    @Test
    public void getBowlTwoStepsAhead(){
        assertEquals(kalahaA.getKalahaBySteps(2),kalahaA.neighbour.neighbour);
    }

    @Test
    public void constructFullKalahaWithBowlsInLoop(){
        assertEquals(kalahaA,kalahaA.getKalahaBySteps(14));
    }

    @Test
    public void addStonesToKalaha(){
        kalahaA.addStones(3);
        assertEquals(3,kalahaA.stones);
    }

    @Test
    public void passOneStoneTurnDoesNotChange(){
        kalahaA.passStones(1);
        assertTrue(kalahaA.owner.isActivePlayer());
    }
    @Test
    public void passStonesWithNotActivePlayerOwnerDoesNotAdd(){
        kalahaA.getKalahaBySteps(7).passStones(1);
        assertEquals(0,kalahaA.getKalahaBySteps(7).stones);
    }
}