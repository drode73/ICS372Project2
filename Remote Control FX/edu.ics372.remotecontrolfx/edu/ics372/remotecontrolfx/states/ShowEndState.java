package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

public class ShowEndState extends PlayerState implements Notifiable {

	private static ShowEndState instance;
	private Timer timer;

	private ShowEndState() {

	}

	public static ShowEndState getInstance() {
		if (instance == null) {
			instance = new ShowEndState();
		}
		return instance;
	}

	public void playRequest() {
		PlayerContext.getInstance().changeState(PlayingState.getInstance());
	}

	public void stopRequest() {
		PlayerContext.getInstance().changeState(UnselectState.getInstance());
	}

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

	public void offRequest() {
		PlayerContext.getInstance().changeState(OffState.getInstance());
	}

	public void selectRequest() {
		PlayerContext.getInstance().changeState(SelectState.getInstance());
	}

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
