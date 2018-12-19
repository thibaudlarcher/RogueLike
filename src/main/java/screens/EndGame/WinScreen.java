package screens.endGame;

import java.awt.*;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import screens.Screen;
import screens.start.StartScreen;

import static java.lang.System.exit;

/**
 * Classe du screen du Win
 *
 * @see Screen
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class WinScreen implements Screen {
	/**
	 * Permet d'afficher que vous avez gagner
	 * @param terminal Asciipanel
	 */
	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("Congratulation, you won!", 3, Color.green);
		terminal.writeCenter("-- press [enter] to restart or [escape] to quit  --", 22);
	}

	/**
	 * Permet de gérer les actions du clavier et ainsi lui donner des actions.
	 * @param key Appuie sur une touche
	 * @return Un Screen
	 */
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
