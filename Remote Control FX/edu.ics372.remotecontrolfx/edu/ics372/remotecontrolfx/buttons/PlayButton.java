package edu.ics372.remotecontrolfx.buttons;

import edu.ics372.remotecontrolfx.states.PlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for Playing request
 * 
 * @author Joshua
 *
 */
public class PlayButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for playing the show
	 * 
	 * @param string
	 */
	public PlayButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.getInstance().playShowRequest();
	}

}
