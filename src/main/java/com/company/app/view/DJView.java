package com.company.app.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import com.company.app.model.BPMObserver;
import com.company.app.model.BeatModelInterface;
import com.company.app.model.BeatObserver;

public class DJView implements BeatObserver, BPMObserver {

	private BeatModelInterface beatModel;

	private ControllerInterface controller;

	private JFrame viewFrame;

	private JPanel viewPanel;

	private JSlider beatBar;

	private JLabel bpmOutputLabel;

	public DJView(BeatModelInterface beatModel, ControllerInterface controller) {
		/*
		 * this.beatModel = beatModel; this.controller = controller;
		 * beatModel.registerObserver((BeatObserver) this);
		 * beatModel.registerObserver((BPMObserver) this);
		 */
	}

	public void createView() {
		viewPanel = new JPanel(new GridLayout(1, 2));
		viewFrame = new JFrame("View");
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.setSize(new Dimension(1000, 800));
		//viewFrame.pack();
		viewFrame.setVisible(true);
		
	}

	@Override
	public void update(BeatModelInterface beatModelInterface) {
		int bpm = beatModelInterface.getBPM();
		if (bpm == 0) {
			bpmOutputLabel.setText("offline");
		}
		bpmOutputLabel.setText("Current BPM: " + bpm);
	}

}
