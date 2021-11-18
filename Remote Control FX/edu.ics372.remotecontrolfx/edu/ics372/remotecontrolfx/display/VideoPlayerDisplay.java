package edu.ics372.remotecontrolfx.display;

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
	public void showSelectedShow(String showDetails);

	/**
	 * Indicate that the selected show is playing
	 */
	public void showPlaying();

	/**
	 * indicate that the selected show is paused
	 */
	public void showPaused();

	/**
	 * indicate that the selected show is stopped
	 */
	public void showStopped();

	/**
	 * indicate that the selected show is rewinding
	 */
	public void showRewinding();

	/**
	 * indicate that the selected show is fast forwarding
	 */
	public void showFastForwarding();

	/**
	 * indicate that the screen saver is ON
	 */
	public void showScreenSaverOn();

	/**
	 * indicate that the screen saver is OFF
	 */
	public void showScreenSaverOff();
}
