package edu.ics372.remotecontrolfx.states;

/**
* @author Kyle McClernon
* @Copyright (c) 2021
*/
import edu.ics372.remotecontrolfx.collections.Show;

/**
 * Represents the Pause Button state
 *
 */
public class PauseState extends PlayerState {
	private static PauseState instance;
	private Show show;

	/**
	 * Private constructor for the singleton pattern
	 */
	private PauseState() {

	}

	/**
	 * Returns the instance
	 * 
	 * @return this object
	 */
	public static PauseState getInstance() {
		if (instance == null) {
			instance = new PauseState();
		}
		return instance;
	}

	/**
	 * Handle Off request
	 * 
	 */
	@Override
	public void offRequest() {
		PlayerContext.getInstance().changeState(OffState.getInstance());
	}

	/**
	 * Handle Play request
	 * 
	 */
	@Override
	public void playRequest() {
		PlayerContext.getInstance().changeState(PlayingState.getInstance());
	}

	/**
	 * Handle Stop request
	 * 
	 */
	@Override
	public void stopRequest() {
		PlayerContext.getInstance().changeState(ShowEndState.getInstance());
	}

	/**
	 * Initialize the state
	 * 
	 */
	@Override
	public void enter() {
		this.show = PlayerContext.getInstance().getShow();
		PlayerContext.getInstance().showPaused();

	}

	@Override
	public void leave() {
		PlayerContext.getInstance().setShow(show);
	}

	/**
	 * Get the show names
	 * 
	 * @return
	 */
	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

}
