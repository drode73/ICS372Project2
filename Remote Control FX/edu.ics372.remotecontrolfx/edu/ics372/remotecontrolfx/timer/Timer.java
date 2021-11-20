package edu.ics372.remotecontrolfx.timer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Timer implements PropertyChangeListener {
	private int timeValue;
	private Notifiable client;

	/**
	 * Sets up the timer
	 *
	 */
	public Timer(Notifiable client, int timeValue) {
		this.client = client;
		this.timeValue = timeValue;
		Clock.getInstance().addPropertyChangeListener(this);
	}

	/**
	 * Change the timer
	 *
	 * 
	 */
	public void addTimeValue(int value) {
		timeValue += value;
	}

	/**
	 * Stops the timer
	 */
	public void stop() {
		Clock.getInstance().removePropertyChangeListener(this);
	}

	/**
	 * Returns the time value left
	 *
	 */
	public int getTimeValue() {
		return timeValue;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if (--timeValue <= 0) {
			client.onTimerRunsOut();
			Clock.getInstance().removePropertyChangeListener(this);
		}
	}
}
