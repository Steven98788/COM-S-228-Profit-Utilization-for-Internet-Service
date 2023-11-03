package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamerTest {
	Town town = new Town(3,3);
	
	Streamer x = new Streamer(town, 1, 2);
	
	//Test if its in the right state
	@Test
	public void test() {
		assertEquals(x.who(), State.STREAMER);
	}

}
