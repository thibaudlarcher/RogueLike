package screens;

import java.awt.*;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

import static java.lang.System.exit;

public class LoseScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("You Dead.", 3, Color.red);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				return new PlayScreen();
			case KeyEvent.VK_ESCAPE:
				exit(1);
		}
		return this;
		//return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}
}

