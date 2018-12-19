package screens;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import screens.Village.VillageScreen;
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
    public HelpScreen (PlayScreen screen){
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
    public HelpScreen (VillageScreen villageScreen, PlayScreen screen){
        this.villageScreen = villageScreen;
        this.player = villageScreen.getPlayer();
        this.world = villageScreen.getVillage();
        this.screen = screen;
        inVilllage = true;
    }

    /**
     * Permet d'afficher l'help sur le terminal asciipanel
     * @param terminal asciipanel
     */
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Help", 2, Color.WHITE);
        terminal.writeCenter("Raccourcis",7, Color.WHITE);
        terminal.writeCenter("[ESCAPE] Afficher le Menu",10, new Color(53, 118, 63));
        terminal.writeCenter("[I] Afficher l'Inventaire du Personnage",12, new Color(53, 118, 63));
        terminal.writeCenter("[C] Afficher les Statistiques du Personnage",14, new Color(53, 118, 63));
        terminal.writeCenter("[P] Recuperer un Item",16, new Color(53, 118, 63));
        terminal.writeCenter("[D] Lacher un Item",18, new Color(53, 118, 63));
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
                if (inVilllage == true){
                    return new MenuScreen(villageScreen, screen);
                } else return new MenuScreen(screen);
        }
        return this;
    }
}
