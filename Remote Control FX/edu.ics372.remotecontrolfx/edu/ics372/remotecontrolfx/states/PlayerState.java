package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.collections.Show;

public abstract class PlayerState {

	/**
	 * leave current state
	 */
	public abstract void leave();

	/**
	 * enter current state
	 */
	public abstract void enter();

	/**
	 * Process play request
	 */
	public void playRequest() {

	}

	/**
	 * Process pause
	 */
	public void pauseRequest() {

	}

	/**
	 * Process stop
	 */
	public void stopRequest() {

	}

	/**
	 * Process rewind
	 */
	public void rewindRequest() {

	}

	/**
	 * Process fast forward
	 */
	public void fastFowardRequest() {

	}

	/**
	 * Process off
	 */
	public void offRequest() {

	}

	/**
	 * Process selection
	 * 
	 * @param show
	 */
	public void selectRequest(Show show) {

	}

	/**
	 * process On
	 */
	public void onRequest() {

	}
}