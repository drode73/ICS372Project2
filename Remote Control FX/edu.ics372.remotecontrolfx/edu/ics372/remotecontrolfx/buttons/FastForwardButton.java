package edu.ics372.remotecontrolfx.buttons;

import edu.ics372.remotecontrolfx.states.PlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for Fast-Forward request
 * 
 * @author Donald Roden
 * @Copyright (c) 2021
 *
 */
public class FastForwardButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for fast-forward
	 * 
	 * @param string
	 */
	public FastForwardButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.getInstance().fastForwardRequest();
	}

}
