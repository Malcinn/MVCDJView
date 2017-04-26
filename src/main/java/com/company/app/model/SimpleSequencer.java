package com.company.app.model;

import java.util.ArrayList;
import java.util.List;

public class SimpleSequencer implements Sequencer, Runnable {

	private static final int SECONDS_IN_MINUTE = 60;

	private static final int MILLISECONDS_IN_SECOND = 1000;

	private static final int ERROR_SLEEP = 1000;

	private List<SequencerObserver> sequencerObservers = new ArrayList<>();

	private SequencerState state = SequencerState.OFF;

	private int bpm = 1;

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
				sequencerStateOn();
			} else {
				sequencerStateOff();
			}
		}
	}

	private void sequencerStateOn() {
		try {
			Thread.sleep(getMilisFromBPM());
			notifySequencerObservers();
		} catch (InterruptedException e) {
			System.out.println("Error ocurred while Thread try to sleep. message: " + e);
		}
	}

	private void sequencerStateOff() {
		System.out.println("Sequencer is off.");
		try {
			Thread.sleep(ERROR_SLEEP);
		} catch (InterruptedException e) {
			System.out.println("Error ocurred while Thread try to sleep. message: " + e);
		}
	}

	/**
	 * @return BPM converted into milliseconds
	 */
	private long getMilisFromBPM() {

		if (bpm >= SECONDS_IN_MINUTE) {
			return MILLISECONDS_IN_SECOND / (bpm / SECONDS_IN_MINUTE);
		}
		return (SECONDS_IN_MINUTE * MILLISECONDS_IN_SECOND) / bpm;
	}

}
