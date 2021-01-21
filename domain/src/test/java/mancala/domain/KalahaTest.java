package mancala.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KalahaTest{
	Kalaha kalaha = new Kalaha();

	@Test
	public void test_getStonesEqualToZero(){
		assertEquals(0,kalaha.getStones());
	}
	
	@Test
	public void test_addStones(){
		kalaha.addStones(3);
		assertEquals(3,kalaha.getStones());
	}


}