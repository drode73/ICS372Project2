package edu.ics372.remotecontrolfx.buttons;

import edu.ics372.remotecontrolfx.states.PlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button to pause the player system
 * 
 * @author Kyle McClernon
 * @Copyright (c) 2021
 *
 */
public class PauseButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for Pause the shows
	 * 
	 * @param string
	 */
	public PauseButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.getInstance().pauseRequest();
	}

}
