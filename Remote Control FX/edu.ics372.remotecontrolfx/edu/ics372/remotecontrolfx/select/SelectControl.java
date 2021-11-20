package edu.ics372.remotecontrolfx.select;

import edu.ics372.remotecontrolfx.states.PlayerContext;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

public class SelectControl extends ListView<Show> {
	public SelectControl() {
		super(ShowList.getInstance().getShows());
		setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				Show show = (Show) getSelectionModel().getSelectedItem();
				PlayerContext.getInstance().onSelectRequest(show.toString());
			}
		});

	}
}
