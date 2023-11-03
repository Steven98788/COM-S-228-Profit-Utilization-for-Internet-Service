package edu.iastate.cs228.hw1;

public class Outage extends TownCell{

	public Outage(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		return State.OUTAGE;
	}

	@Override
	public TownCell next(Town newTown) {
		census(nCensus);
		return new Empty(newTown, row, col);
	}
}
