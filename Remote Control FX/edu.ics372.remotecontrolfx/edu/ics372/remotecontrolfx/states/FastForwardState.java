package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.collections.Show;
import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

public class FastForwardState extends PlayerState implements Notifiable {

	private Timer timer;
	
	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTimerRunsOut() {
		timer.stop();

	}

	@Override
	public void leave() {
		PlayerContext.getInstance().show

	}

	@Override
	public void enter() {
		PlayerContext.getInstance().showFastForward();

	}

}
