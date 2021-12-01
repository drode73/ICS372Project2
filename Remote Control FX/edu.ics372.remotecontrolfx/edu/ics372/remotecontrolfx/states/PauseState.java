package edu.ics372.remotecontrolfx.states;

public class PauseState extends PlayerState {
	private static PauseState instance;
	private PlayerState previousState;

	private PauseState() {

	}

	private PauseState getInstance() {
		if (instance == null) {
			instance = new PauseState();
		}
		return instance;
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enter() {
		PlayerContext.getInstance().showPaused();

	}

	public void offRequest() {
		PlayerContext.getInstance().changeState(OffState.getInstance());
	}

	public void playRequest() {
		PlayerContext.getInstance().changeState(PlayingState.getInstance());
	}

	public void stopRequest() {
		PlayerContext.getInstance().changeState(ShowEndState.getInstance());
	}

}
