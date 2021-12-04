package edu.ics372.remotecontrolfx.timer;

/**
 * @author Joshua Vang
 * @Copyright (c) 2021
 */
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
