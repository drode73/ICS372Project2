package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.display.VideoPlayerDisplay;
import edu.ics372.remotecontrolfx.select.Show;

public class PlayerContext {
	private VideoPlayerDisplay display;
	private PlayerState currentState;
	private static PlayerContext instance;

	/**
	 * Make it a singleton
	 */
	private PlayerContext() {
		instance = this;
		currentState = PlayerOffState.getInstance();
	}

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static PlayerContext getInstance() {
		if (instance == null) {
			instance = new PlayerContext();
		}
		return instance;
	}

	/**
	 * The display could change. So we have to get its reference.
	 * 
	 * @param display The current display object
	 */
	public void setDisplay(VideoPlayerDisplay display) {
		this.display = display;
	}

	/**
	 * Lets Player off state be the starting state adds the object as an observable
	 * for clock
	 */
	public void initialize() {
		instance.changeState(PlayerOffState.getInstance());

	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState the next state
	 */
	public void changeState(PlayerState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * Turn player ON request
	 */
	public void onOnRequest() {
		currentState.onOnRequest();
	}

	/**
	 * Turn player OFF request
	 */
	public void onOffRequest() {
		currentState.onOffRequest();
	}

	/**
	 * Play show PLAY request
	 */
	public void onPlayShowRequest() {
		currentState.onPlayShowRequest();
	}

	/**
	 * Stop show STOP request
	 */
	public void onStopShowRequest() {
		currentState.onStopShowRequest();
	}

	/**
	 * Pause show PAUSE request
	 */
	public void onPauseShowRequest() {
		currentState.onPauseShowRequest();
	}

	/**
	 * Fast-forward show FF request
	 */
	public void onFastForwardRequest() {
		currentState.onFastForwardRequest();
	}

	/**
	 * Rewind show REW request
	 */
	public void onRewindRequest() {
		currentState.onRewindRequest();
	}

	/**
	 * Select show request
	 */
	public void onSelectShowRequest(Show showDetails) {
		currentState.onSelectShowRequest(showDetails);
	}

	/**
	 * Show the time when it done
	 * 
	 * @param time time left for playing
	 */
	public void showTimeLeft(int time) {
		display.showTimeLeft(time);
	}

	/**
	 * Making the player turn on
	 * 
	 */
	public void showPlayerOn() {
		display.showPlayerOn();
	}

	/**
	 * Making the player turn off
	 * 
	 */
	public void showPlayerOff() {
		display.showPlayerOff();
	}

	/**
	 * Selecting the shows from the ShowList
	 * 
	 */
	public void showSelectedShow(Show showDetails) {
		display.showSelectedShow(showDetails);
	}

	/**
	 * Playing the show when being selected
	 * 
	 */
	public void showPlayingShow() {
		display.showPlaying();
	}

	/**
	 * Pause the show when playing
	 * 
	 */
	public void showPausedShow() {
		display.showPaused();
	}

	/**
	 * Stop the show when playing
	 * 
	 */
	public void showStoppedShow() {
		display.showStopped();
	}

	/**
	 * Rewind the show when player is on
	 * 
	 */
	public void showShowRewinding() {
		display.showRewinding();
	}

	/**
	 * Fast-Forward the show when player is on
	 * 
	 */
	public void showShowFastForwarding() {
		display.showFastForwarding();
	}

	/**
	 * Turn on the ScreenSaver
	 * 
	 */
	public void showScreenSaverOn() {
		display.showScreenSaverOn();
	}

	/**
	 * Turn off the ScreenSaver
	 * 
	 */
	public void showScreenSaverOff() {
		display.showScreenSaverOff();
	}
}
