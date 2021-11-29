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
	public void onVideoRunsOut() {
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

}
