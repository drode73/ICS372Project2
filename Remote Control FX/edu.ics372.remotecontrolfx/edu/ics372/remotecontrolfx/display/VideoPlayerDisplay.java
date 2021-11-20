package edu.ics372.remotecontrolfx.display;

import edu.ics372.remotecontrolfx.select.Show;

public interface VideoPlayerDisplay {
	/**
	 * Displays the show time remaining
	 * 
	 * @param time remaining time
	 */
	public void showTimeLeft(int time);

	/**
	 * Indicate that the player is ON
	 */
	public void showPlayerOn();

	/**
	 * Indicate that the player is OFF
	 */
	public void showPlayerOff();

	/**
	 * Indicate that a show was selected
	 */
	public void showSelectedShow(Show showDetails);

	/**
	 * Indicate that the selected show is playing
	 */
	public void showPlaying();

	/**
	 * Indicate that the selected show is paused
	 */
	public void showPaused();

	/**
	 * Indicate that the selected show is stopped
	 */
	public void showStopped();

	/**
	 * Indicate that the selected show is rewinding
	 */
	public void showRewinding();

	/**
	 * Indicate that the selected show is fast forwarding
	 */
	public void showFastForwarding();

	/**
	 * Indicate that the screen saver is ON
	 */
	public void showScreenSaverOn();

	/**
	 * Indicate that the screen saver is OFF
	 */
	public void showScreenSaverOff();

}
