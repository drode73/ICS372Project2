package edu.ics372.remotecontrolfx.collections;

import edu.ics372.remotecontrolfx.states.PlayerContext;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

public class SelectControl extends ListView {
	public SelectControl() {
		super(ShowList.getInstance().getShowsList()); // gets the ObservableList
		setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				System.out.println("clicked on event " + getSelectionModel().getSelectedItem());
				Show show = (Show) getSelectionModel().getSelectedItem();

				// Code to use the Show object
				PlayerContext.getInstance().setShow(show);
				PlayerContext.getInstance().selectRequest(show);
			}
		});

	}
}
