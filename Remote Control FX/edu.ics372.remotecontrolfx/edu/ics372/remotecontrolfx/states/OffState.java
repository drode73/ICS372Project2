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
