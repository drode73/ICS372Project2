package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.select.Show;

public abstract class PlayerState {

	protected boolean isShowSelected;
	protected Show showSelected;

	/**
	 * Initialize the state
	 */
	public abstract void enter();

	/**
	 * Performs the action when leaving the state
	 */
	public abstract void leave();

	/**
	 * Request the actions to be taken when the player system is ON
	 */
	public void onOnRequest() {

	}

	/**
	 * Request the actions to be taken when the player system is OFF
	 */
	public void onOffRequest() {

	}

	/**
	 * Request the actions to be taken when the player system is PLAYING
	 */
	public void onPlayShowRequest() {

	}

	/**
	 * Request the actions to be taken when the player system is STOP
	 */
	public void onStopShowRequest() {

	}

	/**
	 * Request the actions to be taken when the player system is PAUSE
	 */
	public void onPauseShowRequest() {

	}

	/**
	 * Request the actions to be taken when the player system is FAST-FORWARD
	 */
	public void onFastForwardRequest() {

	}

	/**
	 * Request the actions to be taken when the player system is REWIND
	 */
	public void onRewindRequest() {

	}

	/**
	 * Request the actions to be taken when the player system selected the show
	 */
	public void onSelectShowRequest(Show show) {

	}

	/**
	 * Process clock ticks when the timer runs out
	 */
	public void onTimerRunsOut() {

	}

	/**
	 * Process clock ticks when the timer is running
	 */
	public void onTimerTick(int timerValue) {

	}

	/**
	 * Request the actions to be taken when show ends
	 */
	public void onShowEnds() {

	}

	/**
	 * Request the show to be selected
	 */
	public void onSelectRequest(String showDetails) {

	}
}
