package edu.ics372.remotecontrolfx.display;

public interface PlayerDisplay {

	/**
	 * 
	 */
	public void showTimeRemaining(int time);

	/**
	 * 
	 */
	public void showTurnOff();

	/**
	 * 
	 */
	public void showPaused();

	/**
	 * 
	 */
	public void showPlaying();

	/**
	 * 
	 */
	public void showStopped();

	/**
	 * I gave this method a parameter just to check if selecting a show works. If
	 * not needed we can delete the parameter.
	 */
	public void showSelected(String showName, String showLength);

	/**
	 * 
	 */
	public void showUnselected();

	/**
	 * 
	 */
	public void showSelectingOff();

	/**
	 * Indicate that the screen saver is on
	 */
	public void showScreenSaver();
}
