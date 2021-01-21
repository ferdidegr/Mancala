package mancala.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KalahaTest{
	Kalaha kalaha = new Kalaha();

	@Test
	public void test_getStonesEqualToFour(){
		assertEquals(4,kalaha.getStones());
	}
	
	@Test
	public void test_addStones(){
		kalaha.addStones(3);
		assertEquals(7,kalaha.getStones());
	}
}