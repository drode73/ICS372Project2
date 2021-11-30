package edu.ics372.remotecontrolfx.collections;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ShowList {
	private ObservableList<Show> shows = FXCollections.observableArrayList();
	private static ShowList showList;

	/**
	 * Creates the showList
	 */
	private ShowList() {
		allShows();
	}

	/**
	 * Creates instance of ShowList if it doesn't already exist.
	 *
	 * @return instance of ShowList
	 */
	public static ShowList getInstance() {
		if (showList == null) {
			showList = new ShowList();
		}
		return showList;
	}

	/**
	 * Adding a show to the list
	 * 
	 * @param show
	 * @return true if show can be added
	 */
	public boolean insertShow(Show show) {
		return shows.add(show);
	}

	/**
	 * @return return an ObservableList that contains many shows.
	 */
	public ObservableList<Show> getShowsList() {
		return shows;
	}

	/**
	 * Removes a show from showList
	 * 
	 * @param showName
	 * @return true if show could be removed
	 */
	public boolean removeShow(String showName) {
		Iterator<Show> iterator = getShowsIterator();
		while (iterator.hasNext()) {
			Show show = iterator.next();
			if (showName.equals(show.getShowName())) {
				shows.remove(shows.indexOf(show));
				return true;
			}
		}
		return false;
	}

	public Iterator<Show> getShowsIterator() {
		return shows.listIterator();
	}

	private void allShows() {
		for (int i = 1; i < 6; i++) {
			String showName = "N" + i;
			int showLength = 10 * i;
			insertShow(new Show(showName, showLength));
		}
	}

}
