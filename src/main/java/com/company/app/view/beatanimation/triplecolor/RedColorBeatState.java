package com.company.app.view.beatanimation.triplecolor;

import java.awt.Color;

import javax.swing.JPanel;

public class RedColorBeatState implements TripleColorBeatState {

	private BlinkingTripleColorBeatAnimationStrategy blinkingTripleColorBeatAnimationStrategy;

	public RedColorBeatState(BlinkingTripleColorBeatAnimationStrategy blinkingTripleColorBeatAnimationStrategy) {
		this.blinkingTripleColorBeatAnimationStrategy = blinkingTripleColorBeatAnimationStrategy;
	}

	@Override
	public void paintColor(JPanel jPanel) {
		jPanel.setBackground(Color.RED);
		jPanel.repaint();
		blinkingTripleColorBeatAnimationStrategy
				.setCurrentState(blinkingTripleColorBeatAnimationStrategy.getGreenColorBeatState());
	}

}
