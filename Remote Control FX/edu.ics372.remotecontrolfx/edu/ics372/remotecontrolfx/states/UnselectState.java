package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

public class UnselectState extends PlayerState implements Notifiable {
	private static UnselectState instance;
	private Timer timer;

	private UnselectState() {

	}

	public static UnselectState getInstance() {
		if (instance == null) {
			instance = new UnselectState();
		}
		return instance;
	}

	public void onRequest() {
		timer.setTimeValue(10);
	}

	public void offRequest() {
		PlayerContext.getInstance().changeState(OffState.getInstance());
	}

	@Override
	public void OnTimerTick(int timerValue) {
		// Screen saver State
		// PlayerContext State change-state

	}

	@Override
	public void onTimerRunsOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onVideoRunsOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;

	}

	@Override
	public void enter() {
		timer = new Timer(this, 10);
		PlayerContext.getInstance().showUnselected();

	}

}
