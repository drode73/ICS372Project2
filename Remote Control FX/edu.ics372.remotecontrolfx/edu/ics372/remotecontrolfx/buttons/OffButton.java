package edu.ics372.remotecontrolfx.buttons;

import edu.ics372.remotecontrolfx.states.PlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button to turn off the player
 * 
 * @author Joshua Vang
 *
 */
public class OffButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for turn off player system
	 * 
	 * @param string
	 */
	public OffButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.getInstance().offRequest();
	}

}