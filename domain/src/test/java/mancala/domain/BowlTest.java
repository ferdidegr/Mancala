package mancala.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BowlTest{
	Player playerA = new Player("A","B");
	Bowl bowlB1 = (Bowl)playerA.kalaha.neighbour;
	Bowl bowlA1 = (Bowl)playerA.opponent.kalaha.neighbour;

	@Test
	public void test_getStonesEqualToFour(){
		assertEquals(4,bowlA1.getStones());
	}

	@Test
	public void test_emptySelf(){
		bowlB1.emptySelf();
		assertEquals(0,bowlB1.stones);
	}

	@Test
	public void test_passOneStoneToBowl(){
		bowlB1.passStones(1);
		assertEquals(5,bowlB1.getStones());
	}

	@Test
	public void test_passTwoStonesToBowl(){
		bowlB1.passStones(2);
		assertEquals(5,bowlB1.neighbour.getStones());
	}

	@Test
	public void test_stealAddsBothSides(){
		bowlA1.steal();
		assertEquals(8,bowlA1.owner.kalaha.getStones());
	}

	@Test
	public void test_oppositeEmptyAfterSteal(){
		bowlA1.steal();
		assertEquals(0,bowlA1.opposite.getStones());
	}

	@Test
	public void test_stealOnPassStones1(){
		bowlA1.emptySelf();
		bowlA1.passStones(1);
		assertEquals(0,bowlA1.opposite.getStones());
	}

	@Test
	public void test_noStealWhenNotActivePlayer(){
		bowlB1.emptySelf();
		bowlB1.passStones(1);
		assertEquals(1,bowlB1.getStones());
	}

	@Test
	public void test_ExceptionThrownWhenNotActiveOnStartMove(){
		assertThrows(Exception.class,() -> bowlB1.startMove());
	}

	@Test
	public void test_ExceptionThrownWhenBowlIsEmptyOnStartMove(){
		bowlA1.emptySelf();
		assertThrows(Exception.class,() -> bowlA1.startMove());
	}

	@Test
	public void test_BowlEmptyAfterStartMove() throws Exception{
		bowlA1.startMove();
		assertEquals(0,bowlA1.getStones());
	}

	@Test
	public void test_stealAfterFullRound() throws Exception{
		bowlA1.addStones(9);
		bowlA1.startMove();
		assertEquals(7,bowlA1.owner.kalaha.getStones());
	}

}