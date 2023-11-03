package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasualTest {
	
	Town town = new Town(3,3);
	Casual cas = new Casual(town,1,2);
	
	//Test to see if in reseller state
	@Test
	public void test() {
		assertEquals(cas.who(),State.CASUAL);
	}
}
