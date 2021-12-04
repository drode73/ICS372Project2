package edu.ics372.remotecontrolfx.states;

/**
 * @author Donald Roden
 * @Copyright (c) 2021
 */
import edu.ics372.remotecontrolfx.collections.Show;
import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

/**
 * Represents the Fast-Forward state
 *
 */
public class FastForwardState extends PlayerState implements Notifiable {

	private static FastForwardState instance;
	private Timer timer = null;
	private Show show;
	private int timeLeft;

	/**
	 * Private constructor for the singleton pattern
	 */
	private FastForwardState() {

	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static FastForwardState getInstance() {
		if (instance == null) {
			instance = new FastForwardState();
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
	 */
	@Override
	public void enter() {
		show = PlayerContext.getInstance().getShow();
		timeLeft = show.getShowLength() - show.getElapsedTime();
		int time = (timeLeft % 2 == 0) ? (timeLeft / 2) : (timeLeft / 2) + 1;
		timer = new Timer(this, time);
		PlayerContext.getInstance().showFastForward();
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
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

	/**
	 * Handle the Timer-tick request
	 * 
	 */

	@Override
	public void OnTimerTick(int timerValue) {
		timeLeft -= 2;
		show.setElapsedTime(show.getElapsedTime() + 2);
		if (timeLeft < 0) {
			timeLeft = 0;
		}
		PlayerContext.getInstance().showTimeLeft(timeLeft);

	}

	@Override
	public void onTimerRunsOut() {
		PlayerContext.getInstance().showTimeLeft(0);
		PlayerContext.getInstance().changeState(ShowEndState.getInstance());

	}
}
