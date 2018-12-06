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
        if (player.getGroupCreature().get(0).inventory().getSize() < player.getGroupCreature().get(0).inventory().getSizeMax()) {
            player.getGroupCreature().get(0).pickupItem(world.item(player.x, player.y));
            this.world.itemPickVide(player.x, player.y);
        }
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        Item currentItem = world.item(player.x, player.y);
        if (currentItem != null) {
            terminal.writeCenter("item : "+currentItem.getName(), 15, Color.white);
            terminal.writeCenter("degats : "+Integer.toString(currentItem.getDammage()),16,Color.white);
            if (!(player.getGroupCreature().get(0).inventory().isFull())) {
                terminal.writeCenter("Press [P] to pickup item", 30, Color.GRAY);
            } else {
                terminal.writeCenter("Inventory full", 25, Color.RED);
            }
            terminal.writeCenter("Press [escape] to quit", 31, Color.GRAY);
        }

        if (currentItem == null){
            terminal.writeCenter("Item collected",15,Color.white);
            terminal.writeCenter("Press [escape] to quit", 30, Color.GRAY);
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
