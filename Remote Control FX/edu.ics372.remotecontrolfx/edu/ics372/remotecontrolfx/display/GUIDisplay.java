package edu.ics372.remotecontrolfx.display;

import edu.ics372.remotecontrolfx.buttons.GUIButton;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIDisplay extends Application implements PlayerDisplay {
	private GUIButton offButton;
	private GUIButton onButton;
	private GUIButton pauseButton;
	private GUIButton playButton;
	private GUIButton rewindButton;
	private GUIButton fastForwardButton;
	private GUIButton stopButton;

	private Text playerStatus = new Text("Off\n");
	private Text timerValue = new Text(" ");
	private Text playingStatus = new Text("Not Started");
	private Text showText = new Text("Shows");

	@Override
	public void start(Stage arg0) throws Exception {

	}

	@Override
	public void showTimeRemaining(int time) {
		timerValue.setText("Time Remaining: " + time + "\n");

	}

	@Override
	public void showTurnOff() {
		playerStatus.setText("Off\n");

	}

	@Override
	public void showPaused() {
		playerStatus.setText("Show Paused");

	}

	@Override
	public void showPlaying() {
		playerStatus.setText("Show Playing");

	}

	@Override
	public void showStopped() {
		playerStatus.setText("Show Stoped");
	}

	@Override
	public void showSelected(String showName, String showLength) {
		playerStatus.setText("Show selected: " + showName + "\nShow length: " + showLength + " seconds\n");
		playingStatus.setText("Not Started");

	}

	@Override
	public void showUnselected() {
		playerStatus.setText("Show unselected");

	}

	@Override
	public void showSelectingOff() {
		playerStatus.setText("Off");
	}

	@Override
	public void showScreenSaver() {
		playerStatus.setText("Screen Saver");

	}

}
