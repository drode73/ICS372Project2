package edu.ics372.remotecontrolfx.timer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Timer implements PropertyChangeListener {
	private int timeValue;
	private Notifiable client;

	/**
	 * Sets up the timer for a certain client with an initial time value
	 *
	 * @param client    the client, a Notifiable object
	 * @param timeValue the initial time value after which the timer runs out of
	 *                  time.
	 */
	public Timer(Notifiable client, int timeValue) {
		this.client = client;
		this.timeValue = timeValue;
		Clock.getInstance().addPropertyChangeListener(this);
	}

	/**
	 * Sets the timeValue to a new value
	 * 
	 * @param timeValue
	 */
	public void setTimeValue(int timeValue) {
		this.timeValue = timeValue;
	}

	/**
	 * Returns the time value left
	 *
	 * @return the time value left in the timer
	 */
	public int getTimeValue() {
		return timeValue;
	}

	/**
	 * Stops the timer by deleting itself from the list of observers
	 */
	public void stop() {
		Clock.getInstance().removePropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (--timeValue <= 0) {
			client.onTimerRunsOut();
			Clock.getInstance().removePropertyChangeListener(this);
		} else {
			client.OnTimerTick(timeValue);
		}

	}
}
