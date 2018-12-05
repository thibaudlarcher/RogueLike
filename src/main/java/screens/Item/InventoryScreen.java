package screens.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import asciiPanel.AsciiPanel;
import creature.Creature;
import creature.GroupCreature;
import screens.PlayScreen;
import screens.Screen;
import world.World;

public class InventoryScreen implements Screen {
    private World world;
    private ArrayList<GroupCreature> groupCreature;
    private GroupCreature player;

    public InventoryScreen (GroupCreature player, World world, ArrayList<GroupCreature> groupCreature){
        this.player = player;
        this.world = world;
        this.groupCreature = groupCreature;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        Creature joueur = this.player.getGroupCreature().get(0);
        terminal.writeCenter("INVENTORY", 1, Color.WHITE);
        for (int j = 0; j < 140; j++){
            terminal.write((char) 196, j, 3, Color.WHITE);
            j++;
        }

        for (int i = 0; i < player.getGroupCreature().get(0).inventory().getSize(); i++){
            terminal.write(joueur.inventory().get(i).getName(), 3 + 10 * i, 6, Color.white);
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_I:
                return new PlayScreen(world, player, groupCreature);
        }
        return this;
    }
}