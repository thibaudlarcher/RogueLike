package screens.Combat;

import asciiPanel.AsciiPanel;

import static asciiPanel.AsciiPanel.black;
import static asciiPanel.AsciiPanel.white;

/**
 * Classe de l'affichage des flèches dans le combat
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class AffichageDesign {
    /**
     * Constructeur de la classe AffichageDesign.
     */
    private AffichageDesign() {}

    /**
     * Permet d'afficher la flèche dans le choix du monstre a combattre.
     * @param terminal Asciipanel
     * @param i Valeur de la position
     */
    public static void afficheFleche(AsciiPanel terminal, int i) {
        terminal.write("->",7 + i*30,7,black);
    }
}
