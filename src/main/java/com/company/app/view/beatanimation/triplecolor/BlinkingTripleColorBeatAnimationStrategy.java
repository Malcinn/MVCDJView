package com.company.app.view.beatanimation.triplecolor;

import javax.swing.JPanel;

import com.company.app.view.beatanimation.BeatAnimationStrategy;

public class BlinkingTripleColorBeatAnimationStrategy implements BeatAnimationStrategy {

	private TripleColorBeatState currentState;

	public BlinkingTripleColorBeatAnimationStrategy() {
		this.currentState = new RedColorBeatState(this);
	}

	@Override
	public void paintAnimation(JPanel jPanel) {
		currentState.paintColor(jPanel);
	}

	public TripleColorBeatState getRedColorBeatState() {
		return new RedColorBeatState(this);
	}

	public TripleColorBeatState getGreenColorBeatState() {
		return new GreenColorBeatState(this);
	}

	public TripleColorBeatState getBlueColorBeatState() {
		return new BlueColorBeatState(this);
	}

	public TripleColorBeatState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(TripleColorBeatState currentState) {
		this.currentState = currentState;
	}

}
