package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

public class ShowEndState extends PlayerState implements Notifiable {

	private static ShowEndState instance;
	private Timer timer = null;

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

	@Override
	public void enter() {
		timer = new Timer(this, 10);
		PlayerContext.getInstance().showUnselected();

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
	}

	@Override
	public void OnTimerTick(int timerValue) {
		PlayerContext.getInstance().showTimeLeft(timerValue);

	}

	@Override
	public void onTimerRunsOut() {
		PlayerContext.getInstance().changeState(ScreenSaverState.getInstance());

	}

	@Override
	public void onVideoRunsOut() {
		// TODO Auto-generated method stub

	}

}
