package edu.ics372.remotecontrolfx.states;

/**
 * @author Joshua Vang
 * @Copyright (c) 2021
 */
import edu.ics372.remotecontrolfx.collections.Show;
import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

/**
 * Represents the Playing button state
 *
 */
public class PlayingState extends PlayerState implements Notifiable {
	private static PlayingState instance;
	private Show show;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private PlayingState() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static PlayingState getInstance() {
		if (instance == null) {
			instance = new PlayingState();
		}
		return instance;
	}

	/**
	 * Handle Off request
	 * 
	 */
	public void offRequest() {
		PlayerContext.getInstance().changeState(OffState.getInstance());
	}

	/**
	 * Handle Pause request
	 * 
	 */
	public void pauseRequest() {
		show.setElapsedTime(show.getShowLength() - timer.getTimeValue());
		PlayerContext.getInstance().changeState(PauseState.getInstance());
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
	 * Handle Rewind request
	 * 
	 */
	@Override
	public void rewindRequest() {
		show.setElapsedTime(show.getShowLength() - timer.getTimeValue());
		PlayerContext.getInstance().changeState(RewindState.getInstance());
	}

	/**
	 * Handle Fast-Forward request
	 * 
	 */
	@Override
	public void fastFowardRequest() {
		show.setElapsedTime(show.getShowLength() - timer.getTimeValue());
		PlayerContext.getInstance().changeState(FastForwardState.getInstance());
	}

	/**
	 * Handle the Timer-tick request
	 * 
	 */

	@Override
	public void OnTimerTick(int timerValue) {
		PlayerContext.getInstance().showTimeLeft(timerValue);
	}

	@Override
	public void onTimerRunsOut() {
		PlayerContext.getInstance().showTimeLeft(0);
		PlayerContext.getInstance().changeState(ShowEndState.getInstance());
	}

	/**
	 * Initialize the state
	 */
	@Override
	public void enter() {

		show = PlayerContext.getInstance().getShow();
		timer = new Timer(this, show.getShowLength() - show.getElapsedTime());
		PlayerContext.getInstance().showPlaying();
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		PlayerContext.getInstance().setShow(show);

	}

}
