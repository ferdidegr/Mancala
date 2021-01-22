package mancala.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest{
	Player playerA = new Player("Player A");
	Player playerB = new Player("Player B");
	Player full = new Player("A", "B");

	@BeforeEach
	public void initAll() {
		playerA.setOpponent(playerB);
	}

	@Test
	public void test_namePlayerA(){
		assertEquals("Player A", playerA.name);
	}
	
	@Test
	public void test_linkedOpponents(){
		assertEquals(playerB,playerA.opponent);
		assertEquals(playerA,playerB.opponent);
	}
		
	@Test
	public void test_setActivePlayer(){
		playerA.setActivePlayer();
		assertFalse(playerB.isActivePlayer());
	}

	@Test
	public void test_last4BowlsMadeCorrectly(){
		Kalaha startpoint = new Kalaha(playerA,null);
		Bowl test = new Bowl(startpoint,5);
		assertEquals(test.opposite,test.neighbour.neighbour.neighbour.neighbour);
	}

	@Test
	public void test_14TimesNeighbourIsRound(){
		Kalaha start = full.kalaha;
		assertEquals(start,full.kalaha.neighbour.neighbour.neighbour.neighbour.neighbour.neighbour.neighbour.neighbour.neighbour.neighbour.neighbour.neighbour.neighbour.neighbour);
	}




}