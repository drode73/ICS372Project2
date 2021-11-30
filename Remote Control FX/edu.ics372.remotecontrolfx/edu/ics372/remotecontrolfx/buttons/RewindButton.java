package edu.ics372.remotecontrolfx.buttons;

import edu.ics372.remotecontrolfx.states.PlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for rewind the player system
 * 
 * @author Joshua
 *
 */
public class RewindButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for rewind the show
	 * 
	 * @param string
	 */
	public RewindButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.getInstance().rewindRequest();
	}

}
