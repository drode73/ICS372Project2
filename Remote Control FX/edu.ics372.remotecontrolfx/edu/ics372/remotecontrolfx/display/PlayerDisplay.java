package edu.ics372.remotecontrolfx.display;

public interface PlayerDisplay {

	/**
	 * Displays the show time remaining
	 * 
	 * @param time remaining time
	 */
	public void showTimeRemaining(int time);

	/**
	 * Indicate that the show is off
	 */
	public void showTurnOff();

	/**
	 * Indicate that the show is pause
	 */
	public void showPaused();

	/**
	 * Indicate that the show is playing
	 */
	public void showPlaying();

	/**
	 * Indicate the show is stop
	 */
	public void showStopped();

	/**
	 * Indicate the show is rewind
	 */
	public void showRewind();

	/**
	 * Indicate the show is fast-forward
	 */
	public void showFastForward();

	/**
	 * I gave this method a parameter just to check if selecting a show works. If
	 * not needed we can delete the parameter.
	 */
	public void showSelected(String showName, String showLength);

	/**
	 * Indicate user hasn't select any buttons/shows
	 */
	public void showUnselected();

	/**
	 * Indicate to turn off the player interface
	 */
	public void showSelectingOff();

	/**
	 * Indicate that the screen saver is on
	 */
	public void showScreenSaver();
}
