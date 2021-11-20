package edu.ics372.remotecontrolfx.start;

import edu.ics372.remotecontrolfx.display.GUIDisplay;
import edu.ics372.remotecontrolfx.timer.Clock;
import javafx.application.Application;

public class Main {
	public static void main(String[] args) {
		Clock.getInstance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class, null);// The null param is not necessary
			}
		}.start();
	}

}
