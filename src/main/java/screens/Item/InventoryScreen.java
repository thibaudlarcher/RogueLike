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
        terminal.writeCenter("Taille : " + joueur.inventory().getSize() + "/" + joueur.inventory().getSizeMax(),2,Color.white);
        for (int j = 0; j < 140; j++){
            terminal.write((char) 196, j, 4, Color.WHITE);
            j++;
        }

        // Affichage des ItemArme et leur degats
        for (int i = 0; i < player.getGroupCreature().get(0).inventory().getSize(); i++){
            terminal.write(joueur.inventory().get(i).getName(), 3, 6 + 2 * i, Color.white);
            terminal.write("degats: " + Integer.toString(joueur.inventory().get(i).getDammage()) ,10, 6 + 2 * i, Color.GRAY);
        }

//        for (int j = 0; j < 140; j++){
//            terminal.write((char) 196, j, 10, Color.WHITE);
//            j++;
//        }

//        for (int i = 0; i < player.getGroupCreature().get(0).inventory().getSize(); i++){
//            terminal.write(joueur.inventory().get(i).getName(), 3 + 15 * i, 12, Color.white);
//            terminal.write("Effet: " + Integer.toString(joueur.inventory().get(i).getDammage()) ,3 + 15 * i, 13, Color.GRAY);
//        }
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