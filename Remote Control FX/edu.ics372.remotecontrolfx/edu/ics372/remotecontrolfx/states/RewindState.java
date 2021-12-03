package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.timer.Notifiable;

public class RewindState extends PlayerState implements Notifiable {

	private PlayerState instance;
	private Timer timer;
	
	private RewindState() {
		
	}

	private RewindState getInstance() {
		if (instance == null) {
			instance = new RewindState();
		}
		return instance;
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

	@Override
	public void leave() {
		timer.stop();
		PlayerContext.getInstance().

	}

	@Override
	public void enter() {
		PlaverContext.getInstance().showRewind();

	}
	
	public void offRequest() {
		PlayerContext.getInstance().changeState(OffState.getInstance());
	}

}
