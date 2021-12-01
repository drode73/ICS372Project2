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

/**
 * GUI to implement the Player interface
 * 
 * @author Joshua Vang
 *
 */
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

	/**
	 * Sets up the interface
	 */
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
		VBox displaySystem = new VBox();
		TextFlow statusDisplay = new TextFlow();
		statusDisplay.setPadding(new Insets(5, 5, 5, 5));

		// Display the background and the border to see the status report
		statusDisplay.setStyle("-fx-background-color: white;" + "-fx-border-color: black");
		statusDisplay.setMinWidth(500);
		statusDisplay.setMinHeight(200);

		// The player interface will be turn off automatically
		statusDisplay.getChildren().addAll(playerStatus, showStatusText);
		statusDisplay.getChildren().add(timerValue);
		buttonControls.getChildren().addAll(onButton, offButton, playButton, stopButton, pauseButton, fastForwardButton,
				rewindButton);
		displaySystem.getChildren().addAll(statusDisplay, showText, shows);
		stage.getChildren().addAll(buttonControls, displaySystem);

		Scene scene = new Scene(stage, 560, 550);
		primaryStage.setScene(scene);

		// Title for the UserInterface
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

	/**
	 * Create the timer for the show
	 */
	@Override
	public void showTimeRemaining(int time) {
		timerValue.setText("Remaining: " + time + "\n");
	}

	/**
	 * Display the Off button to turn off the show
	 */
	@Override
	public void showTurnOff() {
		playerStatus.setText("Off\n");
		showStatusText.setText("");
		timerValue.setText("");

	}

	/**
	 * Display the pause button to pause the show
	 */
	@Override
	public void showPaused() {
		playerStatus.setText("Show Paused");

	}

	/**
	 * Display the play button to play the show
	 */
	@Override
	public void showPlaying() {
		show = PlayerContext.getInstance().getShow();
		playerStatus.setText("Show Playing");
		showStatusText.setText(show.getShowName() + " " + show.getShowLength() + " seconds\n");

	}

	/**
	 * Display the stop button to stop the show
	 */
	@Override
	public void showStopped() {
		playerStatus.setText("Show Stoped");
		showStatusText.setText("");
		timerValue.setText("");
	}

	/**
	 * Make the user to select the shows
	 */
	@Override
	public void showSelected(String showName, String showLength) {
		playerStatus.setText("Selected Show");
		showStatusText.setText("Show: " + showName + " Show length: " + showLength + " seconds\n");
		timerValue.setText("");

	}

	/**
	 * Making sure that when turn on every buttons should enable to the player
	 */
	@Override
	public void showUnselected() {
		playerStatus.setText("On");
		showStatusText.setText("");
		timerValue.setText("");

	}

	/**
	 * Making the Off button to turn off the player interface
	 */
	@Override
	public void showSelectingOff() {
		playerStatus.setText("Off");
	}

	/**
	 * Display the Screen-Saver if nothing has been selected for 10 seconds
	 */
	@Override
	public void showScreenSaver() {
		playerStatus.setText("Screen Saver ON!");
		showStatusText.setText("");
		timerValue.setText("");

	}

	/**
	 * Display the rewind button to rewind the show
	 */
	@Override
	public void showRewind() {
		playerStatus.setText("Rewind");

	}

	/**
	 * Display the Fast-Forward button to fast-forward the show
	 */
	@Override
	public void showFastForward() {
		playerStatus.setText("Fast-Forward");

	}

}
