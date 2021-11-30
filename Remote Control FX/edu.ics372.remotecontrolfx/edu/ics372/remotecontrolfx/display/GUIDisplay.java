package edu.ics372.remotecontrolfx.display;

import edu.ics372.remotecontrolfx.buttons.FastForwardButton;
import edu.ics372.remotecontrolfx.buttons.GUIButton;
import edu.ics372.remotecontrolfx.buttons.OffButton;
import edu.ics372.remotecontrolfx.buttons.OnButton;
import edu.ics372.remotecontrolfx.buttons.PauseButton;
import edu.ics372.remotecontrolfx.buttons.PlayButton;
import edu.ics372.remotecontrolfx.buttons.RewindButton;
import edu.ics372.remotecontrolfx.buttons.StopButton;
import edu.ics372.remotecontrolfx.collections.SelectControl;
import edu.ics372.remotecontrolfx.collections.Show;
import edu.ics372.remotecontrolfx.states.PlayerContext;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GUIDisplay extends Application implements PlayerDisplay {
	private Show show;
	private GUIButton offButton;
	private GUIButton onButton;
	private GUIButton pauseButton;
	private GUIButton playButton;
	private GUIButton rewindButton;
	private GUIButton fastForwardButton;
	private GUIButton stopButton;
	private Text playerStatus = new Text("Status: Player Off\n");
	private Text showStatusText = new Text("");
	private Text timerValue = new Text(" ");
	private Text showText = new Text("Shows");

	@Override
	public void start(Stage primaryStage) throws Exception {
		offButton = new OffButton("OFF");
		onButton = new OnButton("ON");
		pauseButton = new PauseButton("PAUSE");
		playButton = new PlayButton("PLAY");
		rewindButton = new RewindButton("REW");
		fastForwardButton = new FastForwardButton("FF");
		stopButton = new StopButton("STOP");

		ListView<Show> shows = new SelectControl();

		HBox stage = new HBox();
		VBox buttonControls = new VBox();
		VBox displayContainer = new VBox();
		TextFlow statusDisplay = new TextFlow();
		statusDisplay.setPadding(new Insets(5, 10, 10, 10));
		statusDisplay.setStyle("-fx-background-color: white;" + "-fx-border-color: black");
		statusDisplay.setMinWidth(500);
		statusDisplay.setMinHeight(140);

		statusDisplay.getChildren().addAll(playerStatus, showStatusText);
		statusDisplay.getChildren().add(timerValue);
		buttonControls.getChildren().addAll(onButton, offButton, playButton, stopButton, pauseButton, fastForwardButton,
				rewindButton);
		displayContainer.getChildren().addAll(statusDisplay, showText, shows);
		stage.getChildren().addAll(buttonControls, displayContainer);

		Scene scene = new Scene(stage, 555, 560);
		primaryStage.setScene(scene);

		primaryStage.setTitle("Remote Control and Player Interface");
		PlayerContext.getInstance().setDisplay(this);
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});

	}

	@Override
	public void showTimeRemaining(int time) {
		timerValue.setText("Time Remaining: " + time + "\n");
	}

	@Override
	public void showTurnOff() {
		playerStatus.setText("Off\n");
		showStatusText.setText("");
		timerValue.setText("");

	}

	@Override
	public void showPaused() {
		playerStatus.setText("Show Paused");

	}

	@Override
	public void showPlaying() {
		show = PlayerContext.getInstance().getShow();
		playerStatus.setText("Show Playing");
		showStatusText.setText("Show: " + show.getShowName() + "\nShow length: " + show.getShowLength() + " seconds\n");

	}

	@Override
	public void showStopped() {
		playerStatus.setText("Show Stoped");
		showStatusText.setText("");
		timerValue.setText("");
	}

	@Override
	public void showSelected(String showName, String showLength) {
		playerStatus.setText("Selected Show");
		showStatusText.setText("Show: " + showName + "\nShow length: " + showLength + " seconds\n");
		timerValue.setText("");

	}

	@Override
	public void showUnselected() {
		playerStatus.setText("On");
		showStatusText.setText("");
		timerValue.setText("");

	}

	@Override
	public void showSelectingOff() {
		playerStatus.setText("Off");
	}

	@Override
	public void showScreenSaver() {
		playerStatus.setText("Screen Saver ON!");
		showStatusText.setText("");
		timerValue.setText("");

	}

}
