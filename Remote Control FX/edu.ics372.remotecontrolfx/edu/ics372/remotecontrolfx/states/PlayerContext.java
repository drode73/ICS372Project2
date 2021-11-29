package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.collections.Show;
import edu.ics372.remotecontrolfx.display.PlayerDisplay;

public class PlayerContext {
	private PlayerDisplay display;
	private PlayerState currentState;
	private static PlayerContext instance;
	private Show show;

	/**
	 * Private constructor for singleton
	 */
	private PlayerContext() {
		instance = this;
		currentState = OffState.getInstance();

	}

	/**
	 * Get single instance
	 * 
	 * @return
	 */
	public static PlayerContext getInstance() {
		if (instance == null) {
			instance = new PlayerContext();
		}
		return instance;
	}

	/**
	 * set display
	 * 
	 * @param display
	 */
	public void setDisplay(PlayerDisplay display) {
		this.display = display;
	}

	/**
	 * Lets idle unselected be the default starting state
	 */
	public void initialize() {
		// set state to idle unselected
		// instance.changeState(idleState.getInstance());
	}

	/**
	 * Changes current state
	 * 
	 * @param newState
	 */
	public void changeState(PlayerState newState) {
		currentState.leave();
		currentState = newState;
		currentState.enter();
	}

	public void showVideoPlayerOff() {
		display.showTurnOff();
	}

	public void showSelected() {
		display.showSelected(show.getShowName(), Integer.toString(show.getShowLength()));
	}

	public void showUnselected() {
		display.showUnselected();
	}

	public void showSelectOff() {
		display.showSelectingOff();
	}

	public void showScreenSaver() {
		display.showScreenSaver();

	}

	public void showTimeLeft(int time) {
		display.showTimeRemaining(time);
	}

	public void offRequest() {
		currentState.offRequest();
	}

	public void onRequest() {
		currentState.onRequest();
	}

	public void selectRequest() {
		currentState.selectRequest();
	}

	public void playShowRequest() {
		currentState.playRequest();
	}

	public void pauseRequest() {
		currentState.onRequest();
	}

	public void stopRequest() {
		currentState.stopRequest();
	}

	public void rewindRequest() {
		currentState.rewindRequest();
	}

	public void fastForwardRequest() {
		currentState.fastFowardRequest();
	}

	public PlayerState getCurrentState() {
		return currentState;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Show getShow() {
		return this.show;
	}
}