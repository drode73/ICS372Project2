package edu.ics372.remotecontrolfx.buttons;

import edu.ics372.remotecontrolfx.states.PlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for turn on the player
 * 
 * @author Joshua Vang
 *
 */
public class OnButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for turn on the player interface
	 * 
	 * @param string
	 */
	public OnButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.getInstance().onRequest();
	}

}