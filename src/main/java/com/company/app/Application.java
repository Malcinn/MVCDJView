package com.company.app;

import com.company.app.controller.BeatController;
import com.company.app.controller.ControllerInterface;
import com.company.app.model.BeatModel;
import com.company.app.model.BeatModelInterface;
import com.company.app.model.Sequencer;
import com.company.app.model.SimpleSequencer;


public class Application {

	public static void main(String[] args) {
		Sequencer sequencer = new SimpleSequencer();
		BeatModelInterface beatModel = new BeatModel(sequencer);
		ControllerInterface controller = new BeatController(beatModel);
	}

}
