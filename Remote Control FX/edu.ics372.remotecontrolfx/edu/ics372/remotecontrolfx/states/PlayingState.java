package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.collections.Show;
import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

public class PlayingState extends PlayerState implements Notifiable {
	private static PlayingState instance;
	private Show show = null;
	private Timer timer = null;

	private PlayingState() {

	}

	public static PlayingState getInstance() {
		if (instance == null) {
			instance = new PlayingState();
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
