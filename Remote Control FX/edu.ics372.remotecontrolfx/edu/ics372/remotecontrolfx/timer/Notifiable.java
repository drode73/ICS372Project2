package edu.ics372.remotecontrolfx.timer;

public interface Notifiable {

	/**
	 * Process timer runs out event
	 */
	public void onTimerRunsOut();
}
