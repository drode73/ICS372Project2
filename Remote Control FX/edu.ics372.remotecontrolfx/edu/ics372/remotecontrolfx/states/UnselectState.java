package edu.ics372.remotecontrolfx.states;

/**
 * @author Kyle McClernon
 * @Copyright (c) 2021
 */
import edu.ics372.remotecontrolfx.collections.Show;
import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

/**
 * Represents the Unselect state
 *
 */
public class UnselectState extends PlayerState implements Notifiable {
	private static UnselectState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private UnselectState() {

	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static UnselectState getInstance() {
		if (instance == null) {
			instance = new UnselectState();
		}
		return instance;
	}

	/**
	 * Handle On request
	 * 
	 */
	public void onRequest() {
		timer.setTimeValue(10);
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
		timer.setTimeValue(10);
	}

	/**
	 * Handle Select request
	 * 
	 */
	public void selectRequest(Show show) {
		PlayerContext.getInstance().setShow(show);
		PlayerContext.getInstance().changeState(SelectState.getInstance());
	}

	/**
	 * Handle Play request
	 * 
	 */
	public void playRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * Handle Rewind request
	 * 
	 */
	public void rewindRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * Handle Fast-forward request
	 * 
	 */
	public void fastFowardRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * Handle the Timer-tick request
	 * 
	 */
	@Override
	public void onTimerRunsOut() {
		// Screen saver State
		ScreenSaverState.getInstance().setPreviousState(this);
		// PlayerContext State change-state
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
		PlayerContext.getInstance().showUnselected();

	}

	public void leave() {
		timer.stop();
		timer = null;

	}
}
