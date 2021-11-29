package edu.ics372.remotecontrolfx.buttons;

import edu.ics372.remotecontrolfx.states.PlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PlayButton extends GUIButton implements EventHandler<ActionEvent> {

	public PlayButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		// Process to play, if show is selected
		PlayerContext.getInstance().playShowRequest();
	}

}
