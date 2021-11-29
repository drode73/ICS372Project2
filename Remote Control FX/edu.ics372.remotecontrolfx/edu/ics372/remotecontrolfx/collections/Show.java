package edu.ics372.remotecontrolfx.collections;

public class Show {
	private String showName;
	private int showLength;
	private int elapsedTime;

	public Show(String showName, int showLength) {
		this.showName = showName;
		this.setShowLength(showLength);
		elapsedTime = 0;
	}

	public String getShowName() {
		return showName;
	}

	public int getShowLength() {
		return showLength;
	}

	public void setShowLength(int showLength) {
		this.showLength = showLength;
	}

	public int getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	@Override
	public String toString() {
		return showName + " " + showLength + " seconds";
	}
}
