package edu.ics372.remotecontrolfx.states;

/**
 * @author Kyle McClernon
 * @Copyright (c) 2021
 */
import edu.ics372.remotecontrolfx.collections.Show;
import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

/**
 * Represents the Select state
 *
 */
public class SelectState extends PlayerState implements Notifiable {
	private static SelectState instance;
	private Show show;
	private Timer timer;

	/**
	 * Private constructor for singleton pattern.
	 */
	private SelectState() {

	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static SelectState getInstance() {
		if (instance == null) {
			instance = new SelectState();
		}

		return instance;
	}

	/**
	 * Handle On request
	 * 
	 */
	@Override
	public void onRequest() {
		timer.setTimeValue(10);
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
	 * Handle Select request
	 * 
	 */
	@Override
	public void selectRequest(Show show) {
		PlayerContext.getInstance().setShow(show);
		timer.setTimeValue(10);
		PlayerContext.getInstance().showSelected();
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
	 * Handle Pause request
	 * 
	 */
	@Override
	public void pauseRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * Handle Stop request
	 * 
	 */
	@Override
	public void stopRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * Handle Rewind request
	 * 
	 */
	@Override
	public void rewindRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * Handle Fast-forward request
	 * 
	 */
	@Override
	public void fastFowardRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * Handle the Timer-tick request
	 * 
	 */
	@Override
	public void onTimerRunsOut() {
		ScreenSaverState.getInstance().setPreviousState(this);
		PlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}

	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub
	}

	/**
	 * Initialize the state
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 10);
		PlayerContext.getInstance().showSelected();
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
