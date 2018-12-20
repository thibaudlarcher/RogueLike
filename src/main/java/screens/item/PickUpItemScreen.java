package screens.item;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import object.items.*;
import screens.PlayScreen;
import screens.Screen;
import screens.village.VillageScreen;
import world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Classe de l'ecran pour recupérer un item.
 */
public class PickUpItemScreen implements Screen {

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
     * Stock les monstres.
     */
    private ArrayList<GroupCreature> groupCreature;

    /**
     * Stock une variable pour savoir si le joueur est dans le village ou non.
     */
    private boolean inVillage;

    /**
     * Constructeur de la classe
     * @param screen un playscreen
     */
    public PickUpItemScreen(PlayScreen screen) {
        this.screen = screen;
        this.world = screen.getWorld();
        this.player = screen.getPlayer();
        this.groupCreature = screen.getGroupCreature();
        inVillage = false;
    }

    /**
     * Constructeur alternatif
     * @param villageScreen un villagescreen
     * @param screen un playscreen
     */
    public PickUpItemScreen(VillageScreen villageScreen, PlayScreen screen) {
        this.villageScreen = villageScreen;
        this.screen = screen;
        this.world = villageScreen.getVillage();
        this.player = villageScreen.getPlayer();
        inVillage = true;
    }

    /**
     * Méthode pour récupérer un item.
     */
    private void pickUpItem() {
        if (world.item(player.x,player.y) != null) {
            if (player.getGroupCreature().get(0).inventory().getSize() < player.getGroupCreature().get(0).inventory().getSizeMax()) {
                player.getGroupCreature().get(0).pickupItem(world.item(player.x, player.y));
                this.world.itemPickVide(player.x, player.y);
            }
        }
    }

    /**
     * Méthode pour gérer l'affichage.
     * @param terminal Asciipanel
     */
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.setDefaultBackgroundColor(new Color(24, 75, 123));
        terminal.clear();
        Item currentItem = world.item(player.x, player.y);
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

            if (!(player.getGroupCreature().get(0).inventory().isFull())) {
                terminal.writeCenter("Press [P] to pickup item", 30, Color.GRAY);
            } else {
                terminal.writeCenter("Inventory full", 25, Color.RED);
            }
            terminal.writeCenter("Press [ESCAPE] to resume game", 31, Color.GRAY);
        }

        if (currentItem == null) {
            terminal.writeCenter("item collected",15,Color.white);
            terminal.writeCenter("Press [ESCAPE] to resume game", 30, Color.GRAY);
        }
    }

    /**
     * Méthode pour gérer les interactions avec l'utilisateur.
     * @param key Appuie sur une touche
     * @return un ecran pour récupérer un item
     */
    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_ESCAPE:
                if (inVillage == true) {
                    return new VillageScreen(villageScreen, screen);
                } else return new PlayScreen(world, screen.getVillage(), player, groupCreature);
            case KeyEvent.VK_P: pickUpItem();
                return this;
        }
        return this;
    }
}
