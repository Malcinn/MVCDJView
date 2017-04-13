package com.company.app.model;

public interface BeatModelInterface {

	/**
	 * This method is called after BeatModel is instantiated.
	 */
	public void initalize();

	/**
	 * Method turn beat generator on.
	 */
	public void on();

	/**
	 * method turn generator off.
	 */
	public void off();

	/**
	 * method set beats per minute. After is called the beat frequency changes
	 * immediately.
	 * 
	 * @param bpm
	 */
	public void setBPM(int bpm);

	/**
	 * method return bets per minute.
	 */
	public int getBPM();

	/**
	 * Register observer that want to be notified on every beat change.
	 * 
	 * @param beatObserver
	 */
	public void registerObserver(BeatObserver beatObserver);

	/**
	 * Unregister every Beat observer.
	 * 
	 * @param beatObserver
	 */
	public void removeObserver(BeatObserver beatObserver);

	/**
	 * Method notifies beat observers;
	 */
	public void notifyBeatObservers();

	/**
	 * Register observer that want to be notified on every beat per minute
	 * change. change.
	 * 
	 * @param bpmObserver
	 */
	public void registerObserver(BPMObserver bpmObserver);

	/**
	 * Unregister beat per minute observer.
	 * 
	 * @param bpmObserver
	 */
	public void removeObserver(BPMObserver bpmObserver);

	/**
	 * Method notifies beat per minute observers.
	 */
	public void notifyBPMObservers();
}
