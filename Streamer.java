package edu.iastate.cs228.hw1;

public class Streamer extends TownCell{

	public Streamer(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.STREAMER;
	}

	@Override
	public TownCell next(Town newTown) {
	census(nCensus);
			
		if (nCensus[EMPTY] + nCensus[OUTAGE] < 2) {
			return new Reseller(newTown, row, col);
		}else if (nCensus[RESELLER] > 0){
			return new Outage(newTown, row, col);
		}else if (nCensus[OUTAGE] > 0){
			return new Empty(newTown, row, col);
		}else if (nCensus[CASUAL] > 4) {
			return new Streamer(newTown, row, col);
		}else{
			return new Streamer(newTown, row, col);
		}
	}
}
