package screens.menu;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import screens.PlayScreen;
import screens.Screen;
import screens.village.VillageScreen;
import world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Classe du screen d'aide
 *
 * @see Screen
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class HelpScreen implements Screen {
    /**
     * Le Screen du jeu
     */
    private PlayScreen screen;

    /**
     * Le screen du village
     */
    private VillageScreen villageScreen;

    /**
     * Le World
     */
    private World world;

    /**
     * La créature
     */
    private GroupCreature player;

    /**
     * Le groupe de créature
     */
    private ArrayList<GroupCreature> GroupCreature;

    /**
     * Booléan si c'est dans le village
     */
    private boolean inVilllage;

    /**
     * Constructeur du HelpScreen
     * @param screen Screen du jeu
     */
    public HelpScreen(PlayScreen screen) {
        this.screen = screen;
        this.GroupCreature = screen.getGroupCreature();
        this.player = screen.getPlayer();
        this.world = screen.getWorld();
        inVilllage = false;
    }

    /**
     * Constructeur alternatif de la classe HelpScreen
     * @param villageScreen Screen du village
     * @param screen Screen du jeu
     */
    public HelpScreen(VillageScreen villageScreen, PlayScreen screen) {
        this.villageScreen = villageScreen;
        this.player = villageScreen.getPlayer();
        this.world = villageScreen.getVillage();
        this.screen = screen;
        inVilllage = true;
    }

    /**
     * Permet d'afficher l'help sur le terminal asciipanel.
     * @param terminal asciipanel
     */
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.setDefaultBackgroundColor(new Color(24, 75, 123));
        terminal.clear();

        for (int j = 0; j < 140; j++) {
            terminal.write((char) 196, j, 3, Color.WHITE);
            j++;
        }

        terminal.writeCenter("AIDE", 1, Color.WHITE);
        terminal.writeCenter("Raccourcis",5, Color.WHITE);
        terminal.writeCenter("[ESCAPE] Afficher le menu",8, AsciiPanel.brightBlack);
        terminal.writeCenter("[I] Afficher l'Inventaire du Personnage",10, AsciiPanel.brightBlack);
        terminal.writeCenter("[C] Afficher les Statistiques du Personnage",12, AsciiPanel.brightBlack);
        terminal.writeCenter("[P] Recuperer un item",14, AsciiPanel.brightBlack);
        terminal.writeCenter("[D] Lacher un item",16, AsciiPanel.brightBlack);
        terminal.writeCenter("But du jeu",22, AsciiPanel.brightWhite);
        terminal.writeCenter("Le but est d'explorer le donjon a travers les differents niveaux et de trouver la sortie (portail rouge)",24, AsciiPanel.brightBlack);
        terminal.writeCenter("tout en survivant face aux monstres. Vous pourrez trouver differents objets afin de vous aidez.",25, AsciiPanel.brightBlack);
        terminal.writeCenter("Il existe egalement un portail bleu qui vous menera au village, ou vous pourrez vendre ou acheter des items.",26, AsciiPanel.brightBlack);
        terminal.writeCenter("Condition de victoire ",31, AsciiPanel.brightWhite);
        terminal.writeCenter("Vous gagnerez une fois le niveau 99 passe.",33, AsciiPanel.brightBlack);

        terminal.writeCenter("[ENTER] or [ESCAPE] to go to the menu",41, AsciiPanel.brightWhite);
    }

    /**
     * Permet de gérer les actions du clavier et ainsi lui donner des actions.
     * @param key Appuie sur une touche
     * @return Un Screen
     */
    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_H:
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_ESCAPE:
                if (inVilllage == true) {
                    return new MenuScreen(villageScreen, screen);
                } else return new MenuScreen(screen);
        }
        return this;
    }
}