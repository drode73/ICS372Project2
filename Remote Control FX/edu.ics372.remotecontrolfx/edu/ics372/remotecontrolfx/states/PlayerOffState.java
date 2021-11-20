package edu.ics372.remotecontrolfx.states;

public class PlayerOffState extends PlayerState {

	private static PlayerOffState instance;

	private PlayerOffState() {
	}

	public static PlayerOffState getInstance() {
		if (instance == null) {
			instance = new PlayerOffState();
		}
		return instance;
	}

	@Override
	public void enter() {
		PlayerContext.getInstance().showPlayerOff();

	}

	@Override
	public void leave() {
		PlayerContext.getInstance().showPlayerOn();

	}

}
