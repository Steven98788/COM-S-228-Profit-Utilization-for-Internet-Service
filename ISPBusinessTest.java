package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ISPBusinessTest {

    Town t = new Town(4,4);


//checks the profit return to the number of casual
    @Test
    public void test() {
        t.randomInit(10);
        assertEquals(ISPBusiness.getProfit(t),1);
    }
}