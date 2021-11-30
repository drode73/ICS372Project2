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

	public void pauseRequest() {
		timer.setTimeValue(10);
	}

	public void selectRequest() {
		PlayerContext.getInstance().changeState(SelectState.getInstance());
	}

	public void playRequest() {
		timer.setTimeValue(10);
	}

	public void rewindRequest() {
		timer.setTimeValue(10);
	}

	public void fastFowardRequest() {
		timer.setTimeValue(10);
	}

	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTimerRunsOut() {
		// Screen saver State
		ScreenSaverState.getInstance().setPreviousState(this);
		// PlayerContext State change-state
		PlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}

	public void leave() {
		timer.stop();
		timer = null;

	}

	@Override
	public void enter() {
		timer = new Timer(this, 10);
		PlayerContext.getInstance().showUnselect();

	}

}
