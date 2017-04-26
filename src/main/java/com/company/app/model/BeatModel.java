package com.company.app.model;

import java.util.ArrayList;
import java.util.List;

public class BeatModel implements BeatModelInterface, SequencerObserver {

	private List<BeatObserver> beatObservers = new ArrayList<>();

	private List<BPMObserver> bpmObservers = new ArrayList<>();

	private Sequencer sequencer;

	private int bpm = 90;

	public BeatModel(Sequencer sequencer) {
		this.sequencer = sequencer;
	}

	@Override
	public void initalize() {
		setUpSequencer();
	}

	private void setUpSequencer() {
		sequencer.setTempoInBPM(bpm);
		Thread thread = new Thread(new SimpleSequencer());
		thread.start();
	}

	@Override
	public void on() {
		sequencer.start();
	}

	@Override
	public void off() {
		sequencer.stop();
	}

	@Override
	public void setBPM(int bpm) {
		this.bpm = bpm;
		sequencer.setTempoInBPM(bpm);
		notifyBPMObservers();
	}

	@Override
	public int getBPM() {
		return bpm;
	}

	@Override
	public void registerObserver(BeatObserver beatObserver) {
		beatObservers.add(beatObserver);
	}

	@Override
	public void removeObserver(BeatObserver beatObserver) {
		beatObservers.remove(beatObserver);
	}

	@Override
	public void notifyBeatObservers() {
		for (BeatObserver beatObserver : beatObservers) {
			beatObserver.update(this);
		}
	}

	@Override
	public void registerObserver(BPMObserver bpmObserver) {
		bpmObservers.add(bpmObserver);
	}

	@Override
	public void removeObserver(BPMObserver bpmObserver) {
		bpmObservers.remove(bpmObserver);
	}

	@Override
	public void notifyBPMObservers() {
		for (BPMObserver bpmObserver : bpmObservers) {
			bpmObserver.update(this);
		}
	}

	@Override
	public void beatEvent() {
		notifyBeatObservers();
	}

}
