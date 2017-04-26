package com.company.app.controller;

import javax.management.modelmbean.ModelMBean;

import com.company.app.model.BeatModelInterface;
import com.company.app.view.DJView;

public class BeatController implements ControllerInterface {

	private BeatModelInterface beatModel;

	private DJView djView;

	public BeatController(BeatModelInterface beatModel) {
		this.beatModel = beatModel;
		djView = new DJView(this, beatModel);
		djView.createView();
		djView.createControls();
		djView.disableStopMenuItem();
		djView.enableStartMenuItem();
		beatModel.initalize();
	}

	@Override
	public void start() {
		beatModel.on();
		djView.disableStartMenuItem();
		djView.enableStopMenuItem();
	}

	@Override
	public void stop() {
		beatModel.off();
		djView.enableStartMenuItem();
		djView.disableStopMenuItem();
	}

	@Override
	public void setBPM(int bpm) {
		beatModel.setBPM(bpm);
	}

	@Override
	public void increaseBPM() {
		beatModel.setBPM(beatModel.getBPM() + 1);
	}

	@Override
	public void decreaseBPM() {
		beatModel.setBPM(beatModel.getBPM() - 1);
	}

}
