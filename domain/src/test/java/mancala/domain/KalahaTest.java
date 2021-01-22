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
    public void constructKalahaWithBowlsInLoop(){
        assertEquals(kalahaA,kalahaA.getKalahaBySteps(14));
    }
}