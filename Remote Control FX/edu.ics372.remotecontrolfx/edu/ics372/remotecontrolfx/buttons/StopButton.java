package edu.ics372.remotecontrolfx.buttons;

import edu.ics372.remotecontrolfx.states.PlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for Stop request
 * 
 * @author Joshua
 *
 */
public class StopButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for stopping the show
	 * 
	 * @param string
	 */
	public StopButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.getInstance().stopRequest();
	}

}
