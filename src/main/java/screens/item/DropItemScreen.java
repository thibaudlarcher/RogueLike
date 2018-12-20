package screens.item;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import object.items.Item;
import screens.PlayScreen;
import screens.Screen;
import screens.village.VillageScreen;
import world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Classe du screen pour drop un item.
 *
 * @see Screen
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */
public class DropItemScreen implements Screen {

    /**
     * Stock le playscreen.
     */
    private PlayScreen screen;

    /**
     * Stock le villagescreen.
     */
    private VillageScreen villageScreen;

    /**
     * Stock le world.
     */
    private World world;

    /**
     * Stock le joueur.
     */
    private GroupCreature player;

    /**
     * Stock les monstre.
     */
    private ArrayList<GroupCreature> groupCreature;

    /**
     * Stock la position de l'item a dropper.
     */
    private int pos;

    /**
     * Stock une variable pour savoir si le joueur est dans le village ou non.
     */
    private boolean inVillage;

    /**
     * Constructeur de la classe.
     * @param screen un playscreen.
     * @param pos l'indice de l'item a droppper.
     */
    public DropItemScreen(PlayScreen screen, int pos) {
        this.screen = screen;
        this.world = screen.getWorld();
        this.player = screen.getPlayer();
        this.groupCreature = screen.getGroupCreature();
        this.pos = pos;
        inVillage = false;
    }

    /**
     * Constructeur alternatif de la classe
     * @param villageScreen un villagescreen.
     * @param screen un playscreen.
     * @param pos l'indice de l'item a droppper.
     */
    public DropItemScreen(VillageScreen villageScreen, PlayScreen screen, int pos) {
        this.villageScreen = villageScreen;
        this.screen = screen;
        this.world = villageScreen.getVillage();
        this.player = villageScreen.getPlayer();
        this.pos = pos;
        inVillage = true;
    }

    /**
     * Methode pour dropper un item.
     */
    public void dropItem() {
        if (player.getGroupCreature().get(0).inventory().get(pos) != null) {
            Item item = player.getGroupCreature().get(0).inventory().get(pos);
            player.getGroupCreature().get(0).inventory().remove(item);
            this.world.itemDropPlein(player.x, player.y, item);
        }
    }

    /**
     * Méthode pour l'affichage du screen.
     * @param terminal Asciipanel
     */
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.setDefaultBackgroundColor(new Color(24, 75, 123));
        terminal.clear();
        Item currentItem = player.getGroupCreature().get(0).inventory().get(pos);
        if (currentItem != null) {
            if (currentItem.getType() == "arme") {
                terminal.writeCenter("item : " + currentItem.getName(), 15, Color.white);
                terminal.writeCenter("degats : " + Integer.toString(currentItem.getDammage()), 16, Color.white);
                terminal.writeCenter("valeur : " + Integer.toString(currentItem.getValeur()), 17, Color.white);
            } else if (currentItem.getType() == "potion") {
                terminal.writeCenter("item : " + currentItem.getName(), 15, Color.white);
                terminal.writeCenter("soins : " + Integer.toString(currentItem.getEffet()), 16, Color.white);
                terminal.writeCenter("valeur : " + Integer.toString(currentItem.getValeur()), 17, Color.white);
            } else if (currentItem.getType() == "armure") {
                terminal.writeCenter("item : " + currentItem.getName(), 15, Color.white);
                terminal.writeCenter("defense : " + Integer.toString(currentItem.getDefense()), 16, Color.white);
                terminal.writeCenter("valeur : " + Integer.toString(currentItem.getValeur()), 17, Color.white);
            } else if (currentItem.getType() == "botte") {
                terminal.writeCenter("item : " + currentItem.getName(), 15, Color.white);
                terminal.writeCenter("defense : " + Integer.toString(currentItem.getDefense()), 16, Color.white);
                terminal.writeCenter("valeur : " + Integer.toString(currentItem.getValeur()), 17, Color.white);
            } else if (currentItem.getType() == "casque") {
                terminal.writeCenter("item : " + currentItem.getName(), 15, Color.white);
                terminal.writeCenter("defense : " + Integer.toString(currentItem.getDefense()), 16, Color.white);
                terminal.writeCenter("valeur : " + Integer.toString(currentItem.getValeur()), 17, Color.white);
            } else if (currentItem.getType() == "pantalon") {
                terminal.writeCenter("item : " + currentItem.getName(), 15, Color.white);
                terminal.writeCenter("defense : " + Integer.toString(currentItem.getDefense()), 16, Color.white);
                terminal.writeCenter("valeur : " + Integer.toString(currentItem.getValeur()), 17, Color.white);
            }

            terminal.writeCenter("Press [D] to drop item",30,Color.GRAY);
            terminal.writeCenter("Press [ESCAPE] to resume game",31,Color.GRAY);
        } else {
            terminal.writeCenter("item drop",15,Color.white);
            terminal.writeCenter("Press [ESCAPE] to resume game",30,Color.GRAY);
        }
    }

    /**
     * Méthode pour gérer les interractions avec l'utilisateur.
     * @param key Appuie sur une touche
     * @return
     */
    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_ESCAPE:
                if (inVillage == true) {
                    return new VillageScreen(villageScreen, screen);
                } else return new PlayScreen(world, screen.getVillage(), player, groupCreature);
            case KeyEvent.VK_D: dropItem();
                return this;
        }
        return this;
    }
}
