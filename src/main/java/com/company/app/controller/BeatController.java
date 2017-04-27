package com.company.app.controller;

import com.company.app.model.BPMObserver;
import com.company.app.model.BeatModelInterface;
import com.company.app.model.BeatObserver;
import com.company.app.view.DJView;

public class BeatController implements ControllerInterface {

	private static final int BPM_STEP = 1;

	private BeatModelInterface beatModel;

	private DJView djView2;

	public BeatController(BeatModelInterface beatModel) {
		this.beatModel = beatModel;
		this.djView2 = new DJView(this, beatModel);
		beatModel.registerObserver((BeatObserver) djView2);
		beatModel.registerObserver((BPMObserver) djView2);
		beatModel.initalize();
		djView2.initialize();
	}

	@Override
	public void start() {
		beatModel.on();
	}

	@Override
	public void stop() {
		beatModel.off();
	}

	@Override
	public void setBPM(int bpm) {
		beatModel.setBPM(bpm);
	}

	@Override
	public void increaseBPM() {
		beatModel.setBPM(beatModel.getBPM() + BPM_STEP);
	}

	@Override
	public void decreaseBPM() {
		beatModel.setBPM(beatModel.getBPM() - BPM_STEP);
	}

}
