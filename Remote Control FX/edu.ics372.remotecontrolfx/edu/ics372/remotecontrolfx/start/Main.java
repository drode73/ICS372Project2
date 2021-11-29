package edu.ics372.remotecontrolfx.start;

import edu.ics372.remotecontrolfx.display.GUIDisplay;
import javafx.application.Application;

public class Main {
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class, null);
			}
		}.start();
	}
}