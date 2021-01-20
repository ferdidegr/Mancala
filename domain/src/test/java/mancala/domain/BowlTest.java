package mancala.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BowlTest{

	@Test
	public void test_getStonesEqualToFour(){
		Bowl bowl = new Bowl();
		assertEquals(4,bowl.getStones());
	}
}