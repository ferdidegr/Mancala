package mancala.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KalahaTest {

    Kalaha kalahaA = new Kalaha();
    Kalaha kalahaEmpty = new Kalaha();

    @BeforeEach
    public void init(){
        kalahaA.makeLoop();
    }

    @Test
    public void getBowlTwoStepsAhead(){
        assertEquals(kalahaA.getKalahaBySteps(2),kalahaA.getNeighbour().getNeighbour());
    }

    @Test
    public void constructFullKalahaWithBowlsInLoop(){
        assertEquals(kalahaA,kalahaA.getKalahaBySteps(14));
    }

    @Test
    public void addStonesToKalaha(){
        kalahaA.addStones(3);
        assertEquals(3,kalahaA.getStones());
    }

    @Test
    public void passOneStoneTurnDoesNotChange(){
        kalahaA.passStones(1);
        assertTrue(kalahaA.getOwner().isActivePlayer());
    }
    @Test
    public void passStonesWithNotActivePlayerOwnerDoesNotAdd(){
        kalahaA.getKalahaBySteps(7).passStones(1);
        assertEquals(0,kalahaA.getKalahaBySteps(7).getStones());
    }

    @Test
    public void noSidesAreEmptyGameHasNotEnded(){
        assertFalse(kalahaA.hasGameEnded());
    }

    @Test
    public void justSideAEmptyGameHasEnded(){
        kalahaEmpty.makeLoop(new int[]{0,0,0,0,0,0,4,4,4,4,4,4});
    }

    @Test
    public void justSideBEmptyGameHasEnded(){
        kalahaEmpty.makeLoop(new int[]{4,4,4,4,4,4,0,0,0,0,0,0});
    }

    @Test
    public void bothSidesEmptyGameHasEnded(){
        kalahaEmpty.makeLoop(new int[]{0,0,0,0,0,0,0,0,0,0,0,0});
    }


}