package edu.ics372.remotecontrolfx.states;

/**
 * @author Donald Roden
 * @Copyright (c) 2021
 */
import edu.ics372.remotecontrolfx.collections.Show;
import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

/**
 * Represents the Rewind button state
 *
 */
public class RewindState extends PlayerState implements Notifiable {
	private static RewindState instance;
	private Timer timer = null;
	private Show show;
	private int timeLeft;

	/**
	 * Private constructor for the singleton pattern
	 */
	private RewindState() {

	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static RewindState getInstance() {
		if (instance == null) {
			instance = new RewindState();
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
		PlayerContext.getInstance().setShow(show);
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
	 * Handle the Timer-tick request
	 * 
	 */

	@Override
	public void OnTimerTick(int timerValue) {
		timeLeft += 2;
		show.setElapsedTime(show.getElapsedTime() - 2);
		if (timeLeft > show.getShowLength()) {
			timeLeft = show.getShowLength();
		}

		PlayerContext.getInstance().showTimeLeft(timeLeft);
	}

	@Override
	public void onTimerRunsOut() {
		show.setElapsedTime(0);
		PlayerContext.getInstance().changeState(SelectState.getInstance());
	}

	/**
	 * Initialize the state
	 */
	@Override
	public void enter() {
		// timeLeft = show.getShowLength() - show.getElapsedTime();
		show = PlayerContext.getInstance().getShow();
		int time = (show.getElapsedTime() % 2 == 0) ? (show.getElapsedTime() / 2) : (show.getElapsedTime() / 2) + 1;
		timer = new Timer(this, time);
		timeLeft = show.getShowLength() - show.getElapsedTime();
		PlayerContext.getInstance().showRewind();
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		PlayerContext.getInstance().setShow(show);

	}

	/**
	 * Set the show to Rewind
	 * 
	 * @param show
	 */
	public void setShow(Show show) {
		this.show = show;
	}
}
