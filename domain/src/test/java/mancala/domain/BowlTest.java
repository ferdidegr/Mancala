package mancala.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BowlTest {

    Kalaha kalahaA = new Kalaha();

    @BeforeEach
    public void init(){
        kalahaA.makeLoop();
    }

    @Test
    public void findOppositeForA6(){
        Bowl A1 = (Bowl)kalahaA.getKalahaBySteps(8);
        assertEquals(A1.getOpposite(),A1.getKalahaBySteps(12));
    }

}