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
	 * Player is ON
	 */
	public void showPlayerOn();

	/**
	 * Player is OFF
	 */
	public void showPlayerOff();

	/**
	 * Select the show
	 */
	public void showSelectedShow(Show showDetails);

	/**
	 * Show is playing on the Player
	 */
	public void showPlaying();

	/**
	 * Show is paused on the Player
	 */
	public void showPaused();

	/**
	 * Show is stop on the Player
	 */
	public void showStopped();

	/**
	 * Show is rewind on the Player
	 */
	public void showRewinding();

	/**
	 * Show is fast-forward on the Player
	 */
	public void showFastForwarding();

	/**
	 * Screen saver is ON
	 */
	public void showScreenSaverOn();

	/**
	 * Screen saver is OFF
	 */
	public void showScreenSaverOff();

}
