package screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

/**
 * Interface du Screen
 *
 * @see Screen
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public interface Screen {
	/**
	 * Permet d'afficher dans le asciiPanel
	 * @param terminal Asciipanel
	 */
	void displayOutput(AsciiPanel terminal);

	/**
	 * Permet de gérer les actions du clavier et ainsi lui donner des actions.
	 * @param key Appuie sur une touche
	 * @return Un Screen
	 */
	Screen respondToUserInput(KeyEvent key);
}
