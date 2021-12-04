package edu.ics372.remotecontrolfx.states;

/**
 * @author Joshua Vang
 * @Copyright (c) 2021
 */
import edu.ics372.remotecontrolfx.collections.Show;

/**
 * Super class for all states
 * 
 *
 */
public abstract class PlayerState {

	/**
	 * Performs any necessary clean up while leaving the state
	 */
	public abstract void leave();

	/**
	 * Initializes the state
	 */
	public abstract void enter();

	/**
	 * Process Play request
	 */
	public void playRequest() {

	}

	/**
	 * Process Pause request
	 */
	public void pauseRequest() {

	}

	/**
	 * Process Stop request
	 */
	public void stopRequest() {

	}

	/**
	 * Process Rewind request
	 */
	public void rewindRequest() {

	}

	/**
	 * Process Fast-Forward request
	 */
	public void fastFowardRequest() {

	}

	/**
	 * Process a Off request
	 */
	public void offRequest() {

	}

	/**
	 * Process selection for the show
	 * 
	 * @param show
	 */
	public void selectRequest(Show show) {

	}

	/**
	 * Process a On request
	 */
	public void onRequest() {

	}

}
