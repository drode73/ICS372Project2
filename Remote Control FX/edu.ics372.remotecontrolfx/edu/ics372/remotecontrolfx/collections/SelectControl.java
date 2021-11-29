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

				Show show = (Show) getSelectionModel().getSelectedItem();
				PlayerContext.getInstance().setShow(show);
				PlayerContext.getInstance().selectRequest();
			}
		});

	}
}
