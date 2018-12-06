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

public class DropItemScreen implements Screen {
    private World world;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    int pos;

    public DropItemScreen(ArrayList<GroupCreature> groupCreature, GroupCreature player, World world, int pos){
        this.world=world;
        this.player = player;
        this.groupCreature = groupCreature;
        this.pos = pos;
    }

    public void dropItem(){
        Item item = player.getGroupCreature().get(0).inventory().get(pos);
        player.getGroupCreature().get(0).inventory().remove(item);
        this.world.itemDropPlein(player.x,player.y,item);
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        Item currentItem = player.getGroupCreature().get(0).inventory().get(pos);
        if (currentItem != null){
            terminal.writeCenter("item : "+currentItem.getName(),15, Color.white);
            terminal.writeCenter("degats : "+Integer.toString(currentItem.getDammage()),16, Color.white);
            terminal.writeCenter("Press [D] to drop item",30,Color.GRAY);
            terminal.writeCenter("Press [escape] to quit",31,Color.GRAY);
        }
        else {
            terminal.writeCenter("Item drop",15,Color.white);
            terminal.writeCenter("Press [escape] to quit",30,Color.GRAY);
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE: return new PlayScreen(world, player, groupCreature);
            case KeyEvent.VK_D: dropItem();
            return this;
        }
        return this;
    }
}
