package com.company.app.model;

public interface BeatObserver {

	/**
	 * Method That is executed on BeatObserver while it is notified.
	 * 
	 * @param beatModelInterface
	 */
	public void updateBeat(BeatModelInterface beatModelInterface);
}
