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

import static asciiPanel.AsciiPanel.brightRed;
import static asciiPanel.AsciiPanel.white;
import static java.lang.System.exit;

/**
 * Classe du screen de quitter le jeu
 *
 * @see Screen
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class QuitterScreen implements Screen {
    /**
     * Screen du jeu
     */
    private PlayScreen screen;

    /**
     * Screen du village
     */
    private VillageScreen villageScreen;

    /**
     * World
     */
    private World world;

    /**
     * Player
     */
    private GroupCreature player;

    /**
     * groupe de créature
     */
    private ArrayList<GroupCreature> groupCreature;

    /**
     * Choix de quitter
     */
    private int choix;

    /**
     * Savoir si on est dans le villages
     */
    private boolean inVillage;

    /**
     * Constructeur de la classe QuitterScreen
     * @param screen Screen du jeu
     */
    public QuitterScreen(PlayScreen screen){
        this.screen = screen;
        this.world=screen.getWorld();
        this.groupCreature = screen.getGroupCreature();
        this.player = screen.getPlayer();
        inVillage = false;
    }

    /**
     * Constructeur alternatif
     * @param villageScreen Screen villages
     * @param screen Screen du jeu
     */
    public QuitterScreen(VillageScreen villageScreen, PlayScreen screen){
        this.villageScreen = villageScreen;
        this.screen = screen;
        this.world = villageScreen.getVillage();
        this.player = villageScreen.getPlayer();
        inVillage = true;
    }

    /**
     * Permet d'afficher le choix de quitter
     * @param terminal asciipanel
     */
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Voulez-vous quitter la partie ?",15,Color.white);
        terminal.write("Oui",63,20,this.choix == 0 ? brightRed : white);
        terminal.write("Non",73,20,this.choix == 1 ? brightRed : white);
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
                switch (this.choix){
                    case 0 :
                        exit(0);
                        break;
                    case 1 :
                        if (inVillage == true){
                            return new MenuScreen(villageScreen, screen);
                        } else return new MenuScreen(screen);

                }
            case KeyEvent.VK_LEFT:
                choix = (choix+1)%2;
                break;
            case KeyEvent.VK_RIGHT:
                choix = (choix-1)%2;
                if (choix<0){
                    choix = (choix+2);
                }
                break;

        }
        return this;
    }
}