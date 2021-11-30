package edu.ics372.remotecontrolfx.timer;

public interface Notifiable {

	/**
	 * Process timer ticks
	 */
	public void OnTimerTick(int timerValue);

	/**
	 * Process timer runs out event
	 */
	public void onTimerRunsOut();

}