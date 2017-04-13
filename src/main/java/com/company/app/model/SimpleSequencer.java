package com.company.app.model;

import java.util.ArrayList;
import java.util.List;

public class SimpleSequencer implements Sequencer, Runnable {

	private static final int SECONDS_IN_MINUTE = 60;

	private static final int MILLISECONDS_IN_SECOND = 1000;

	private List<SequencerObserver> sequencerObservers = new ArrayList<>();

	private SequencerState state = SequencerState.OFF;

	private int bpm = 0;

	@Override
	public void start() {
		state = SequencerState.ON;
	}

	@Override
	public void stop() {
		state = SequencerState.OFF;
	}

	@Override
	public void setTempoInBPM(int bpm) {
		this.bpm = bpm;
	}

	@Override
	public void registerObserver(SequencerObserver sequencerObserver) {
		sequencerObservers.add(sequencerObserver);
	}

	@Override
	public void removeObserver(SequencerObserver sequencerObserver) {
		sequencerObservers.remove(sequencerObserver);
	}

	@Override
	public void notifySequencerObservers() {
		for (SequencerObserver sequencerObserver : sequencerObservers) {
			sequencerObserver.beatEvent();
		}
	}

	@Override
	public void run() {
		while (true) {
			if (state.equals(SequencerState.ON)) {
				try {
					Thread.sleep(getMilisFromBPM());
					notifySequencerObservers();
				} catch (InterruptedException e) {
					System.out.println("Error ocurred while Thread try to sleep. message: " + e);
				}
			} else {
				System.out.println("Sequencer is off.");
			}
		}
	}

	private long getMilisFromBPM() {
		return (bpm / SECONDS_IN_MINUTE) * MILLISECONDS_IN_SECOND;
	}

}
