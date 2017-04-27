package com.company.app.view.beatanimation.triplecolor;

import java.awt.Color;

import javax.swing.JPanel;

public class BlueColorBeatState implements TripleColorBeatState {

	private BlinkingTripleColorBeatAnimationStrategy blinkingTripleColorBeatAnimationStrategy;

	public BlueColorBeatState(BlinkingTripleColorBeatAnimationStrategy blinkingTripleColorBeatAnimationStrategy) {
		this.blinkingTripleColorBeatAnimationStrategy = blinkingTripleColorBeatAnimationStrategy;
	}

	@Override
	public void paintColor(JPanel jPanel) {
		jPanel.setBackground(Color.BLUE);
		jPanel.repaint();
		blinkingTripleColorBeatAnimationStrategy
				.setCurrentState(blinkingTripleColorBeatAnimationStrategy.getRedColorBeatState());
	}

}
