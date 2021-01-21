package mancala.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest{

	Player playerA = new Player("Player A");
	Player playerB = new Player("Player B");
	

	@Test
	public void test_namePlayerA(){
		assertEquals("Player A", playerA.name);
	}
	
	@Test
	public void test_linkedOpponents(){
		playerA.setOpponent(playerB);
		assertEquals(playerB,playerA.opponent);
		assertEquals(playerA,playerB.opponent);
	}
		
	@Test
	public void test_setActivePlayer(){
		playerA.setOpponent(playerB);
		playerA.setActivePlayer();
		assertFalse(playerB.isActivePlayer());
	}
	
}