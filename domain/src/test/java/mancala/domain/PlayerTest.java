package mancala.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest{
	Player playerA = new Player("A","B");

	@Test
	public void makePlayerWithOpponent(){
		assertEquals("B",playerA.getOpponent().getName());
	}

	@Test
	public void switchActivePlayer(){
		playerA.switchActivePlayer();
		assertTrue(playerA.getOpponent().isActivePlayer());
	}
}