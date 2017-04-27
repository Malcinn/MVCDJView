package com.company.app.view.beatanimation.triplecolor;

import java.awt.Color;

import javax.swing.JPanel;

public class GreenColorBeatState implements TripleColorBeatState {

	private BlinkingTripleColorBeatAnimationStrategy blinkingTripleColorBeatAnimationStrategy;

	public GreenColorBeatState(BlinkingTripleColorBeatAnimationStrategy blinkingTripleColorBeatAnimationStrategy) {
		this.blinkingTripleColorBeatAnimationStrategy = blinkingTripleColorBeatAnimationStrategy;
	}

	@Override
	public void paintColor(JPanel jPanel) {
		jPanel.setBackground(Color.GREEN);
		jPanel.repaint();
		blinkingTripleColorBeatAnimationStrategy
				.setCurrentState(blinkingTripleColorBeatAnimationStrategy.getBlueColorBeatState());
	}

}
