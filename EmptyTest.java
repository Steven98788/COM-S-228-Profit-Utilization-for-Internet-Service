package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyTest {
	
	Town town = new Town(3,3);
	Empty empty = new Empty(town,1,2);
	
	//Test to see if in reseller state
	@Test
	public void test() {
		assertEquals(empty.who(),State.EMPTY);
	}
}
