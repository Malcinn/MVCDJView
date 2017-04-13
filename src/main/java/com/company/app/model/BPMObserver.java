package com.company.app.model;

public interface BPMObserver {

	/**
	 * Method That is executed on BMPObserver while it is notified.
	 * 
	 * @param beatModelInterface
	 */
	public void update(BeatModelInterface beatModelInterface);
}
