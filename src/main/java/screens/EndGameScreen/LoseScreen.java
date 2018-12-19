package screens.EndGameScreen;

import java.awt.*;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import screens.PlayScreen;
import screens.Screen;

import static asciiPanel.AsciiPanel.brightRed;
import static asciiPanel.AsciiPanel.white;
import static java.lang.System.exit;

/**
 * Classe du screen du game over
 *
 * @see Screen
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class LoseScreen implements Screen {
	/**
	 * Stock le player
	 */
	private GroupCreature player;

	/**
	 * choix du key event
	 */
	private int choix;

	/**
	 * Constructeur de la classe
	 * @param player sauvegarde l'etat du player
	 */
	public LoseScreen(GroupCreature player){
		this.player=player;
	}

	/**
	 * Permet d'afficher si on veut continuer ou quitter
	 * @param terminal asciipanel
	 */
	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("Continue", 10,this.choix == 0 ? brightRed : white );
		terminal.writeCenter("Quit", 15,this.choix == 1 ? brightRed : white);
	}

	/**
	 * Si on veut continuer alors tout sera supprimer sauf l'or gagné
	 */
	public void restartchoice(){
		player.getGroupCreature().get(0).setPointDeVie(player.getGroupCreature().get(0).getPointDeVieMax());
		player.getGroupCreature().get(0).inventory().removeAllItem();
		player.getGroupCreature().get(0).inventory().setArmeEquipe(false);
		player.getGroupCreature().get(0).inventory().setArmureEquipe(false);
		player.getGroupCreature().get(0).inventory().setBotteEquipe(false);
		player.getGroupCreature().get(0).inventory().setCasqueEquipe(false);
		player.getGroupCreature().get(0).inventory().setPantalonEquipe(false);
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
			switch (this.choix) {
				case 0:
					restartchoice();
					return new PlayScreen(player);
				case 1:
					exit(1);
					break;
			}
			case KeyEvent.VK_ESCAPE:
				exit(1);
			case KeyEvent.VK_DOWN:
				choix = (choix+1)%2;
				break;
			case KeyEvent.VK_UP:
				choix = (choix-1)%2;
				if (choix<0){
					choix = (choix+2);
				}
				break;
		}
		return this;
	}
}

