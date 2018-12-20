import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import screens.Screen;
import screens.start.StartScreen;

import asciiPanel.AsciiPanel;

/**
 * Classe de la fonction des actions
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class AppletMain extends Applet implements KeyListener {
	/**
	 * Stock le screen asciipanel.
	 */
	private AsciiPanel terminal;

	/**
	 * Screen.
	 */
	private Screen screen;

	/**
	 * Constructeur de la classe AppletMain
	 */
	public AppletMain(){
		super();
		terminal = new AsciiPanel();
		add(terminal);
		screen = new StartScreen();
		addKeyListener(this);
		repaint();
	}

	/**
	 * Permet d'initialiser.
	 */
	@Override
	public void init(){
		super.init();
		this.setSize(terminal.getWidth() + 20, terminal.getHeight() + 20);
	}

	/**
	 * Permet de refresh l'affichage.
	 */
	@Override
	public void repaint(){
		terminal.clear();
		screen.displayOutput(terminal);
		super.repaint();
	}

	/**
	 * Permet de savoir quelle touche est press.
	 * @param e La touche
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		screen = screen.respondToUserInput(e);
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) { }

	@Override
	public void keyTyped(KeyEvent e) { }
}
