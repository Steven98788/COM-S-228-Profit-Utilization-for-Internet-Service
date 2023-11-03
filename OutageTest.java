package edu.iastate.cs228.hw1;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutageTest {

    Town t = new Town(3,3);
    Outage o = new Outage(t, 1, 2);

    //just test if who returns the right state
    @Test
    public void test() {
        assertEquals(o.who(), State.OUTAGE);
    }
}