package com.company.app;

import com.company.app.view.DJView;

public class Application {

	public static void main(String[] args) {
		DJView djView = new DJView(null, null);
		djView.createView();
	}

}
