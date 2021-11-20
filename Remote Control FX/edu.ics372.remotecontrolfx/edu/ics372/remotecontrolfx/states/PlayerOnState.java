package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.timer.Notifiable;
import edu.ics372.remotecontrolfx.timer.Timer;

public class PlayerOnState extends PlayerState implements Notifiable {

	private static PlayerOnState instance;
	private Timer timer;

	private PlayerOnState() {
		instance = this;

	}

	public static PlayerOnState getInstance() {
		if (instance == null) {
			instance = new PlayerOnState();
		}
		return instance;
	}

	@Override
	public void enter() {
		timer = new Timer(this, 10);
		PlayerContext.getInstance().showPlayerOn();
		PlayerContext.getInstance().showTimeLeft(timer.getTimeValue());

	}

	@Override
	public void leave() {
		timer.stop();
		PlayerContext.getInstance().showPlayerOff();
		PlayerContext.getInstance().showTimeLeft(0);

	}

}
