package edu.ics372.remotecontrolfx.states;

/**
 * 
 * 
 * @author Joshua Vang
 * @Copyright (c) 2021
 */

public class OffState extends PlayerState {

	private static OffState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private OffState() {

	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static OffState getInstance() {
		if (instance == null) {
			instance = new OffState();
		}
		return instance;
	}

	/**
	 * handle player request
	 * 
	 */
	public void onRequest() {
		PlayerContext.getInstance().changeState(UnselectState.getInstance());
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void leave() {
	}

	@Override
	public void enter() {
		PlayerContext.getInstance().showVideoPlayerOff();

	}

}
