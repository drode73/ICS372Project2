package edu.ics372.remotecontrolfx.states;

/**
 * @author Joshua Vang
 * @Copyright (c) 2021
 */
import edu.ics372.remotecontrolfx.collections.Show;

/**
 * Represents the Screensaver state
 *
 */
public class ScreenSaverState extends PlayerState {
	private static ScreenSaverState instance;
	private PlayerState previousState;
	private Show show;

	/**
	 * Private constructor for the singleton pattern
	 */
	private ScreenSaverState() {

	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static ScreenSaverState getInstance() {
		if (instance == null) {
			instance = new ScreenSaverState();
		}
		return instance;
	}

	/**
	 * Set the Previous state on the player
	 * 
	 * @param previousState
	 */
	public void setPreviousState(PlayerState previousState) {
		this.previousState = previousState;
	}

	/**
	 * Set the Show to the Player
	 * 
	 * @param show
	 */
	public void setShow(Show show) {
		this.show = show;
	}

	/**
	 * Handle On request
	 * 
	 */

	public void onRequest() {
		PlayerContext.getInstance().changeState(previousState);
	}

	/**
	 * Handle Off request
	 * 
	 */

	public void offRequest() {
		PlayerContext.getInstance().changeState(OffState.getInstance());
	}

	/**
	 * Handle Select request
	 * 
	 */

	public void selectRequest() {
		PlayerContext.getInstance().changeState(previousState);
	}

	/**
	 * Handle Play request
	 * 
	 */

	public void playRequest() {
		if (previousState.equals(UnselectState.getInstance())) {
			PlayerContext.getInstance().changeState(previousState);
		} else {
			PlayerContext.getInstance().changeState(PlayingState.getInstance());
		}
	}

	/**
	 * Handle Pause request
	 * 
	 */
	public void pauseRequest() {
		PlayerContext.getInstance().changeState(previousState);
	}

	/**
	 * Handle Stop request
	 * 
	 */
	public void stopRequest() {
		PlayerContext.getInstance().changeState(previousState);
	}

	/**
	 * Handle Rewind request
	 * 
	 */
	public void rewindRequest() {
		PlayerContext.getInstance().changeState(previousState);
	}

	/**
	 * Handle Fast-Forward request
	 * 
	 */

	public void fastForwardRequest() {
		PlayerContext.getInstance().changeState(previousState);
	}

	/**
	 * Initialize the state
	 */
	@Override
	public void enter() {
		PlayerContext.getInstance().showScreenSaver();
		this.show = PlayerContext.getInstance().getShow();

	}

	@Override
	public void leave() {
		PlayerContext.getInstance().setShow(show);

	}
}
