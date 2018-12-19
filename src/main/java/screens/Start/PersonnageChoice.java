package screens.start;

import asciiPanel.AsciiPanel;
import creature.pj.Guerrier;
import creature.pj.Mage;
import screens.PlayScreen;
import screens.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;

import static asciiPanel.AsciiPanel.brightRed;
import static asciiPanel.AsciiPanel.white;

/**
 * Classe du screen du choix de personnage
 *
 * @see Screen
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class PersonnageChoice implements Screen {

    /**
     * Le choix dans le menu
     */
    private int choix;

    /**
     * Permet d'afficher la sélection du personnage
     * @param terminal asciipanel
     */
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Choix du personnage", 10,new Color(255, 255, 255));
        terminal.writeCenter("Guerrier", 15,this.choix == 0 ? brightRed : white);
        terminal.writeCenter("Mage", 20,this.choix == 1 ? brightRed : white );
        terminal.writeCenter("Retour", 25,this.choix == 2 ? brightRed : white);
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
                    case 0 :
                        return new PlayScreen(new Guerrier("Guerrier",30,8));
                    case 1 :
                        return new PlayScreen(new Mage("Mage",100,3,5));
                    case 2 :
                        return new LoadSreen();
                }
            case KeyEvent.VK_DOWN:
                choix = (choix + 1) % 3;
                break;
            case KeyEvent.VK_UP:
                choix = (choix - 1) % 3;
                if (choix < 0) {
                    choix = (choix + 3);
                }
                break;
        }
        return this;
    }
}
