package com.company.app.view.beatanimation;

import java.awt.Color;

import javax.swing.JPanel;

public class BlinkingDoubleColorBeatAnimationStrategy implements BeatAnimationStrategy {

	private boolean isColor = false;

	@Override
	public void paintAnimation(JPanel jPanel) {
		if (!isColor) {
			jPanel.setBackground(Color.BLACK);
			isColor = true;
		} else {
			jPanel.setBackground(Color.WHITE);
			isColor = false;
		}
		jPanel.repaint();
	}

}
