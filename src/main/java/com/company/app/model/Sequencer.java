package com.company.app.model;

public interface Sequencer extends Runnable{

	/**
	 * Method starts sequencer, and set it state to ON;
	 */
	public void start();

	/**
	 * Method stop sequencer, and set it state to OFF;
	 */
	public void stop();

	/**
	 * Method set sequencer tempo in beat per minute.
	 * 
	 * @param bpm
	 */
	public void setTempoInBPM(int bpm);

	/**
	 * method register sequencerObserver that want be notified on every beat.
	 * 
	 * @param sequencerObserver
	 */
	public void registerObserver(SequencerObserver sequencerObserver);

	/**
	 * method unregister sequencerObserver.
	 * 
	 * @param sequencerObserver
	 */
	public void removeObserver(SequencerObserver sequencerObserver);

	/**
	 * method notify sequenceObservers.
	 */
	public void notifySequencerObservers();
}
