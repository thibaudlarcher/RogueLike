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

public class DropItemScreen implements Screen {
    private PlayScreen screen;
    private VillageScreen villageScreen;
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private int pos;
    private boolean inVillage;

    public DropItemScreen(PlayScreen screen, int pos) {
        this.screen = screen;
        this.world = screen.getWorld();
        this.player = screen.getPlayer();
        this.groupCreature = screen.getGroupCreature();
        this.pos = pos;
        inVillage = false;
    }

    public DropItemScreen(VillageScreen villageScreen, PlayScreen screen, int pos) {
        this.villageScreen = villageScreen;
        this.screen = screen;
        this.world = villageScreen.getVillage();
        this.player = villageScreen.getPlayer();
        this.pos = pos;
        inVillage = true;
    }

    public void dropItem() {
        if (player.getGroupCreature().get(0).inventory().get(pos) != null) {
            Item item = player.getGroupCreature().get(0).inventory().get(pos);
            player.getGroupCreature().get(0).inventory().remove(item);
            this.world.itemDropPlein(player.x, player.y, item);
        }
    }

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
