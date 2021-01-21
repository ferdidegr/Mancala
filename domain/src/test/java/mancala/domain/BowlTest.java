package mancala.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BowlTest{
	Player playerA = new Player("A","B");
	Bowl bowl1 = (Bowl)playerA.kalaha.neighbour;

	@Test
	public void test_getStonesEqualToFour(){
		assertEquals(4,bowl1.getStones());
	}

	@Test
	public void test_emptySelf(){
		bowl1.emptySelf();
		assertEquals(0,bowl1.stones);
	}

	@Test
	public void test_passOneStoneToBowl(){
		bowl1.passStones(1);
		assertEquals(5,bowl1.getStones());
	}

	@Test
	public void test_passTwoStonesToBowl(){
		bowl1.passStones(2);
		assertEquals(5,bowl1.neighbour.getStones());
	}
}