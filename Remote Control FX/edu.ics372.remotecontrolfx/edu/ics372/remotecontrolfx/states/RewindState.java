package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.collections.Show;
import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

public class RewindState extends PlayerState implements Notifiable {
	
	private Timer timer;
	
	@Override
	public void OnTimerTick(int timerValue) {
		PlayerContext.getInstance().showTimeLeft(timerValue);

	}

	@Override
	public void onTimerRunsOut() {
		timer.stop();

	}

	@Override
	public void leave() {
		timer.stop();
		PlayerContext.getInstance().show

	}

	@Override
	public void enter() {
		PlayerContext.getInstance().showRewind();
		
	}

}
