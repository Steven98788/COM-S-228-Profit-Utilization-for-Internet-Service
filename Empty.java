package edu.iastate.cs228.hw1;

public class Empty extends TownCell{

	public Empty(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.EMPTY;
	}

	@Override
	public TownCell next(Town newTown) {
		census(nCensus);
	    
		if((nCensus[EMPTY] + nCensus[OUTAGE]) < 2) {
	      return new Reseller(newTown, row, col);
		    } else {
		    return new Casual(newTown, row, col);
		   }
	}

}
