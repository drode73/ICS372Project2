package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.collections.Show;
import edu.ics372.remotecontrolfx.display.PlayerDisplay;

/**
 * The context is an observer for the clock and stores the context info for
 * states
 *
 */
public class PlayerContext {
	private PlayerDisplay display;
	private PlayerState currentState;
	private static PlayerContext instance;
	private Show show;

	/**
	 * Make it a singleton
	 */
	private PlayerContext() {
		instance = this;
		currentState = OffState.getInstance();

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
	public void setDisplay(PlayerDisplay display) {
		this.display = display;
	}

	/**
	 * Lets Show End state be the starting state adds the object as an observable
	 */
	public void initialize() {
		instance.changeState(ShowEndState.getInstance());
	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState the next state
	 */
	public void changeState(PlayerState newState) {
		currentState.leave();
		currentState = newState;
		currentState.enter();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showVideoPlayerOff() {
		display.showTurnOff();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showSelected() {
		display.showSelected(show.getShowName(), Integer.toString(show.getShowLength()));
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showUnselected() {
		display.showUnselected();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showStopped() {
		display.showStopped();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showSelectOff() {
		display.showSelectingOff();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showScreenSaver() {
		display.showScreenSaver();

	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showPlaying() {
		display.showPlaying();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showPaused() {
		display.showPaused();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showRewind() {
		display.showRewind();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showFastForward() {
		display.showFastForward();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 * @param time time left for playing
	 */
	public void showTimeLeft(int time) {
		display.showTimeRemaining(time);
	}

	/**
	 * Process a OFF button request
	 */

	public void offRequest() {
		currentState.offRequest();
	}

	/**
	 * Process a ON button request
	 */
	public void onRequest() {
		currentState.onRequest();
	}

	/**
	 * Process to Select a request
	 */
	public void selectRequest(Show show) {
		currentState.selectRequest(show);
	}

	/**
	 * Process Play request
	 */
	public void playShowRequest() {
		currentState.playRequest();
	}

	/**
	 * Process Pause request
	 */
	public void pauseRequest() {
		currentState.pauseRequest();
	}

	/**
	 * Process Stop request
	 */
	public void stopRequest() {
		currentState.stopRequest();
	}

	/**
	 * Process Rewind request
	 */
	public void rewindRequest() {
		currentState.rewindRequest();
	}

	/**
	 * Process Fast-Forward request
	 */
	public void fastForwardRequest() {
		currentState.fastFowardRequest();
	}

	/**
	 * Get the Current State from the PlayerState
	 * 
	 * @return
	 */
	public PlayerState getCurrentState() {
		return currentState;
	}

	/**
	 * Set the Show
	 * 
	 * @param show
	 */
	public void setShow(Show show) {
		this.show = show;
	}

	/**
	 * Get the show name
	 * 
	 * @return
	 */
	public Show getShow() {
		return this.show;
	}
}