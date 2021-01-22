package mancala.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KalahaTest{
	Kalaha kalaha = new Kalaha();
	Player playerA = new Player("A","B");
	Bowl bowl = (Bowl)playerA.opponent.kalaha.neighbour;

	@Test
	public void test_getStonesEqualToZero(){
		assertEquals(0,kalaha.getStones());
	}
	
	@Test
	public void test_addStones(){
		kalaha.addStones(3);
		assertEquals(3,kalaha.getStones());
	}

	@Test
	public void test_TurnStaysWhenEndingInMancala(){
		bowl.passStones(7);
		assertTrue(playerA.isActivePlayer());
	}

	@Test
	public void test_opponentKalahaSet(){
		assertNotEquals(null,playerA.opponent.kalaha);
	}

	@Test
	public void test_stoneAddedToOwnKalaha(){
		playerA.opponent.kalaha.neighbour.passStones(8);
		assertEquals(1,playerA.kalaha.getStones());
	}

	@Test
	public void test_noStonesAddedToOpponentsKalaha(){
		playerA.kalaha.neighbour.passStones(10);
		assertEquals(0,playerA.opponent.kalaha.getStones());
	}

}