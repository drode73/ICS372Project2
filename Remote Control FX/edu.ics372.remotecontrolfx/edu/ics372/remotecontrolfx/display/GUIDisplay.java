package edu.ics372.remotecontrolfx.display;

import edu.ics372.remotecontrolfx.buttons.FastForwardButton;
import edu.ics372.remotecontrolfx.buttons.GUIButton;
import edu.ics372.remotecontrolfx.buttons.OffButton;
import edu.ics372.remotecontrolfx.buttons.OnButton;
import edu.ics372.remotecontrolfx.buttons.PauseButton;
import edu.ics372.remotecontrolfx.buttons.PlayButton;
import edu.ics372.remotecontrolfx.buttons.RewindButton;
import edu.ics372.remotecontrolfx.buttons.StopButton;
import edu.ics372.remotecontrolfx.select.Show;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIDisplay extends Application implements VideoPlayerDisplay {

	private GUIButton playerOn;
	private GUIButton playerOff;
	private GUIButton pauseShow;
	private GUIButton playShow;
	private GUIButton rewindShow;
	private GUIButton fastforwardShow;
	private GUIButton stopShow;
	private Label statusText;
	private ListView<Show> showList;
	private Text timerValue = new Text("            ");

	@Override
	public void start(Stage primaryStage) throws Exception {
		playerOn = new OnButton("On");
		playerOff = new OffButton("Off");
		playShow = new PlayButton("Play");
		stopShow = new StopButton("Stop");
		pauseShow = new PauseButton("Pause");
		fastforwardShow = new FastForwardButton("FF");
		rewindShow = new RewindButton("Rew");

	}

	@Override
	public void showTimeLeft(int time) {
		timerValue.setText(" " + time);

	}

	@Override
	public void showPlayerOn() {
		statusText.setText("ON");

	}

	@Override
	public void showPlayerOff() {
		statusText.setText("OFF");

	}

	@Override
	public void showSelectedShow(Show showDetails) {
		statusText.setText("Player: Show selected [" + showDetails + "]");

	}

	@Override
	public void showPlaying() {
		statusText.setText("PLAYING");

	}

	@Override
	public void showPaused() {
		statusText.setText("PAUSED");

	}

	@Override
	public void showStopped() {
		statusText.setText("STOP");

	}

	@Override
	public void showRewinding() {
		statusText.setText("REWIND");

	}

	@Override
	public void showFastForwarding() {
		statusText.setText("FAST FORWARD");

	}

	@Override
	public void showScreenSaverOn() {
		statusText.setText("SCREEN SAVER ON");
	}

	@Override
	public void showScreenSaverOff() {
		statusText.setText("SCREEN SAVER OFF");

	}

}
