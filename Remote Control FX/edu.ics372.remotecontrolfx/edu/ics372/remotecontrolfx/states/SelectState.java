package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

public class SelectState extends PlayerState implements Notifiable {
	private static SelectState instance;
	private Timer timer;

	private SelectState() {

	}

	public static SelectState getInstance() {
		if (instance == null) {
			instance = new SelectState();
		}

		return instance;
	}

	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTimerRunsOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub

	}
	
	public void onRequest() {
		PlayerContext.getInstance().changeState(SelectState.getInstance());
	}
	
	public void offRequest() {
		PlayerContext.getInstance().changeState(OffState.getInstance());
	}
	
	public void selectRequest() {
		PlayerContext.getInstance().changeState(SelectState.getInstance());
	}
	
	public void playRequest() {
		PlayerContext.getInstance().changeState(PlayingState.getInstance());
	}
	
	public void pauseRequest() {
		PlayerContext.getInstance().changeState(PauseState.getInstance());
	}
	
	public void stopRequest() {
		PlayerContext.getInstance().changeState(ShowEndState.getInstance());
	}
	
	public void rewindRequest() {
		PlayerContext.getInstance().changeState(RewindState.getInstance());
	}
	
	public void fastForwardRequest() {
		PlayerContext.getInstance().changeState(FastForwardState.getInstance());
	}

}
