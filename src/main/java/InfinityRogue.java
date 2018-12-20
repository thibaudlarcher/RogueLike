import javax.swing.JFrame;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import screens.Screen;
import screens.start.StartScreen;

/**
 * Classe de la fonction principale de lancement du jeu InfinityRogue
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class InfinityRogue extends JFrame implements KeyListener {
	/**
	 * Stock le Screen asciipanel.
	 */
	private AsciiPanel terminal;

	/**
	 * Screen.
	 */
	private Screen screen;

	/**
	 * Constructeur de la classe InfinityRogue.
	 */
	public InfinityRogue(){
		super();
		terminal = new AsciiPanel(140,43); // max 160 max 54
		add(terminal);
		pack();
		screen = new StartScreen();
		addKeyListener(this);
		repaint();
	}

	/**
	 * Permet de refresh le Sceen.
	 */
	@Override
	public void repaint(){
		terminal.clear();
		screen.displayOutput(terminal);
		super.repaint();
	}

	/**
	 * L'évènement du la touche press.
	 * @param e touche
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

	/**
	 * Main.
	 * @param args argument
	 */
	public static void main(String[] args) {
		InfinityRogue app = new InfinityRogue();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}
