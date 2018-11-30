package screens;

import java.awt.*;
import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		terminal.writeCenter("Rogue Like Projet", 1,Color.ORANGE);
		terminal.writeCenter("-- press [enter] to start --", 22);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}
}
