package edu.iastate.cs228.hw1;

public class Reseller extends TownCell{

	public Reseller(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		// TODO Auto-generated method stub
		return State.RESELLER;
	}

	@Override
	public TownCell next(Town newTown) {
		// TODO Auto-generated method stub
		census(nCensus);
		
		if ((nCensus[CASUAL] < 4) || (nCensus[EMPTY] > 2)){
			return new Empty(newTown, row, col);
		}else{
			return new Reseller(newTown, row, col);
		}
	}
}
