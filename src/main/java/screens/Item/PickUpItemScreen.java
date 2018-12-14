package screens.Item;

import asciiPanel.AsciiPanel;
import creature.GroupCreature;
import object.Items.Item;
import screens.PlayScreen;
import screens.Screen;
import world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class PickUpItemScreen implements Screen {
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;

    public PickUpItemScreen(ArrayList<GroupCreature> groupCreature, GroupCreature player, World world) {
        this.world=world;
        this.player = player;
        this.groupCreature = groupCreature;
    }

    private void pickUpItem(){
        if (world.item(player.x,player.y) != null){
            if (player.getGroupCreature().get(0).inventory().getSize() < player.getGroupCreature().get(0).inventory().getSizeMax()) {
                player.getGroupCreature().get(0).pickupItem(world.item(player.x, player.y));
                this.world.itemPickVide(player.x, player.y);
            }
        }
    }

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
            } else if (currentItem.getType() == "potion"){
                terminal.writeCenter("item : " + currentItem.getName(), 15, Color.white);
                terminal.writeCenter("soins : " + Integer.toString(currentItem.getEffet()), 16, Color.white);
                terminal.writeCenter("valeur : " + Integer.toString(currentItem.getValeur()), 17, Color.white);
            } else if (currentItem.getType() == "armure"){
                terminal.writeCenter("item : " + currentItem.getName(), 15, Color.white);
                terminal.writeCenter("defense : " + Integer.toString(currentItem.getDefense()), 16, Color.white);
                terminal.writeCenter("valeur : " + Integer.toString(currentItem.getValeur()), 17, Color.white);
            } else if (currentItem.getType() == "botte"){
                terminal.writeCenter("item : " + currentItem.getName(), 15, Color.white);
                terminal.writeCenter("defense : " + Integer.toString(currentItem.getDefense()), 16, Color.white);
                terminal.writeCenter("valeur : " + Integer.toString(currentItem.getValeur()), 17, Color.white);
            } else if (currentItem.getType() == "casque"){
                terminal.writeCenter("item : " + currentItem.getName(), 15, Color.white);
                terminal.writeCenter("defense : " + Integer.toString(currentItem.getDefense()), 16, Color.white);
                terminal.writeCenter("valeur : " + Integer.toString(currentItem.getValeur()), 17, Color.white);
            } else if (currentItem.getType() == "pantalon"){
                terminal.writeCenter("item : " + currentItem.getName(), 15, Color.white);
                terminal.writeCenter("defense : " + Integer.toString(currentItem.getDefense()), 16, Color.white);
                terminal.writeCenter("valeur : " + Integer.toString(currentItem.getValeur()), 17, Color.white);
            } else if (currentItem.getType() == "pierreTP"){
                terminal.writeCenter("item : " + currentItem.getName(), 15, Color.white);
                terminal.writeCenter("Une pierre tres puissante qui vous permettra de vous rendre au village.",16, Color.WHITE);
            }

            if (!(player.getGroupCreature().get(0).inventory().isFull())) {
                terminal.writeCenter("Press [P] to pickup item", 30, Color.GRAY);
            } else {
                terminal.writeCenter("Inventory full", 25, Color.RED);
            }
            terminal.writeCenter("Press [ESCAPE] to resume game", 31, Color.GRAY);
        }

        if (currentItem == null){
            terminal.writeCenter("Item collected",15,Color.white);
            terminal.writeCenter("Press [ESCAPE] to resume game", 30, Color.GRAY);
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE: return new PlayScreen(world,player, groupCreature);
            case KeyEvent.VK_P: pickUpItem();
            return this;
        }
        return this;
    }
}
