package edu.ics372.remotecontrolfx.states;

public class OffState extends PlayerState {

	private static OffState instance;

	private OffState() {

	}

	public static OffState getInstance() {
		if (instance == null) {
			instance = new OffState();
		}
		return instance;
	}

	public void onRequest() {
		PlayerContext.getInstance().changeState(UnselectState.getInstance());
	}

	@Override
	public void leave() {

	}

	@Override
	public void enter() {
		PlayerContext.getInstance().showVideoPlayerOff();

	}

}
