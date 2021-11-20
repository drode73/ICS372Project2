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
import edu.ics372.remotecontrolfx.states.PlayerContext;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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

		// Current Status of the Player
		statusText = new Label("Player OFF");
		statusText.setMinWidth(50);
		statusText.setMinHeight(50);

		// Create the ShowList
		showList = new ListView<Show>();
		GridPane mainPane = new GridPane();
		mainPane.setHgap(10);
		mainPane.setVgap(10);
		GridPane statusPane = new GridPane();
		GridPane buttonPane = new GridPane();

		// Add buttons to the Left-side of the panel
		buttonPane.add(playerOn, 0, 0);
		buttonPane.add(playerOff, 0, 1);
		buttonPane.add(playShow, 0, 2);
		buttonPane.add(stopShow, 0, 3);
		buttonPane.add(pauseShow, 0, 4);
		buttonPane.add(fastforwardShow, 0, 5);
		buttonPane.add(rewindShow, 0, 6);

		// to add list view control to status pane
		statusPane.add(statusText, 0, 0);
		statusPane.add(showList, 0, 1);
		showList.getItems().add(new Show("n1", 10));
		showList.getItems().add(new Show("n2", 20));
		showList.getItems().add(new Show("n3", 30));
		showList.getItems().add(new Show("n4", 40));
		showList.getItems().add(new Show("n5", 50));
		showList.getSelectionModel().selectedItemProperty()
				.addListener((ObservableValue<? extends Show> ov, Show old_val, Show new_val) -> {
					Show selectedShow = showList.getSelectionModel().getSelectedItem();
					PlayerContext.getInstance().onSelectShowRequest(selectedShow);
				});
		statusPane.setStyle("-fx-background-color: white;");
		statusText.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		mainPane.add(buttonPane, 0, 0);
		mainPane.add(statusPane, 1, 0, 5, 1);
		statusPane.setVgap(10);
		buttonPane.setVgap(10);
		Scene scene = new Scene(mainPane);
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
