package edu.ics372.remotecontrolfx.states;

import edu.ics372.remotecontrolfx.collections.Show;

public class ScreenSaverState extends PlayerState {
	private static ScreenSaverState instance;
	private PlayerState previousState;
	private Show show;

	private ScreenSaverState() {

	}

	public static ScreenSaverState getInstance() {
		if (instance == null) {
			instance = new ScreenSaverState();
		}
		return instance;
	}

	public void setPreviousState(PlayerState previousState) {
		this.previousState = previousState;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public void onRequest() {
		PlayerContext.getInstance().changeState(previousState);
	}

	public void offRequest() {
		PlayerContext.getInstance().changeState(OffState.getInstance());
	}

	public void selectRequest() {
		PlayerContext.getInstance().changeState(previousState);
	}

	public void playRequest() {
		if (previousState.equals(UnselectState.getInstance())) {
			PlayerContext.getInstance().changeState(previousState);
		} else {
			PlayerContext.getInstance().changeState(PlayingState.getInstance());
		}
	}

	public void pauseRequest() {
		PlayerContext.getInstance().changeState(previousState);
	}

	public void stopRequest() {
		PlayerContext.getInstance().changeState(previousState);
	}

	public void rewindRequest() {
		PlayerContext.getInstance().changeState(previousState);
	}

	public void fastForwardRequest() {
		PlayerContext.getInstance().changeState(previousState);
	}

	@Override
	public void leave() {
		PlayerContext.getInstance().setShow(show);

	}

	@Override
	public void enter() {
		PlayerContext.getInstance().showScreenSaver();
		this.show = PlayerContext.getInstance().getShow();

	}

}
