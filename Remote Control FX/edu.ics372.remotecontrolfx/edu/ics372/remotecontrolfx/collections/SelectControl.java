package edu.ics372.remotecontrolfx.collections;

import edu.ics372.remotecontrolfx.states.PlayerContext;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

/**
 * Create a singleton class called ShowList with a list of Show objects. You
 * need to figure out what a Show object should contain, The list could be an
 * ObservableList. You could use the following code to select a show.
 * 
 * @author Kyle McClernon
 * @Copyright (c) 2021
 */
public class SelectControl extends ListView {
	public SelectControl() {
		super(ShowList.getInstance().getShowsList()); // gets the ObservableList
		setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {

				Show show = (Show) getSelectionModel().getSelectedItem();

				// Code to use the Show object
				PlayerContext.getInstance().setShow(show);
				PlayerContext.getInstance().selectRequest(show);
			}
		});

	}
}
