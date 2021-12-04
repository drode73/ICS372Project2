package edu.ics372.remotecontrolfx.states;

/**
 * @author Joshua Vang
 * @Copyright (c) 2021
 */
import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

/**
 * Represents the Show End state
 *
 */
public class ShowEndState extends PlayerState implements Notifiable {

	private static ShowEndState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private ShowEndState() {

	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static ShowEndState getInstance() {
		if (instance == null) {
			instance = new ShowEndState();
		}
		return instance;
	}

	/**
	 * Handle Play request
	 * 
	 */
	public void playRequest() {
		PlayerContext.getInstance().changeState(PlayingState.getInstance());
	}

	/**
	 * Handle Stop request
	 * 
	 */
	public void stopRequest() {
		PlayerContext.getInstance().changeState(UnselectState.getInstance());
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
		PlayerContext.getInstance().changeState(SelectState.getInstance());
	}

	/**
	 * Initialize the state
	 */
	@Override
	public void enter() {
		PlayerContext.getInstance().getShow().setElapsedTime(0);
		PlayerContext.getInstance().showStopped();
		timer = new Timer(this, 10);
		PlayerContext.getInstance().showTimeLeft(10);
	}

	@Override
	public void leave() {
		timer.stop();
		PlayerContext.getInstance().showTimeLeft(0);
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
		ScreenSaverState.getInstance().setPreviousState(UnselectState.getInstance());
		PlayerContext.getInstance().changeState(ScreenSaverState.getInstance());

	}

}
