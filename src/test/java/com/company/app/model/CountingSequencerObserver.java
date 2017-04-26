package com.company.app.model;

public class CountingSequencerObserver implements SequencerObserver {

	private long counter = 0;

	@Override
	public void beatEvent() {
		counter++;
		System.out.println("beatEvent From Sequencer, beat number: " + counter);
	}

	public long getCounter() {
		return counter;
	}

}
