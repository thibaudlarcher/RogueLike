package screens.endGame;

import java.awt.*;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import screens.Screen;
import screens.start.StartScreen;

import static java.lang.System.exit;

public class WinScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("Congratulation, you won!", 3, Color.green);
		terminal.writeCenter("-- press [enter] to restart or [escape] to quit  --", 22);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				return new StartScreen();
			case KeyEvent.VK_ESCAPE:
				exit(1);
		}
		return this;
	}
}
