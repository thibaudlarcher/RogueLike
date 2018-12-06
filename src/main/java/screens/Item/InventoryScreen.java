package screens.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import asciiPanel.AsciiPanel;
import color.Tile;
import creature.Creature;
import creature.GroupCreature;
import screens.PlayScreen;
import screens.Screen;
import world.World;

public class InventoryScreen implements Screen {
    private World world;
    private ArrayList<GroupCreature> groupCreature;
    private GroupCreature player;
    private int pos;

    public InventoryScreen (GroupCreature player, World world, ArrayList<GroupCreature> groupCreature){
        this.player = player;
        this.world = world;
        this.groupCreature = groupCreature;
        this.pos = -1;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
//        afficheMenuItem(terminal, this);
        Creature joueur = this.player.getGroupCreature().get(0);
        terminal.writeCenter("INVENTORY", 1, Color.WHITE);
        terminal.writeCenter("Taille : " + joueur.inventory().getSize() + "/" + joueur.inventory().getSizeMax(),2,Color.white);
        for (int j = 0; j < 140; j++){
            terminal.write((char) 196, j, 4, Color.WHITE);
            j++;
        }

        // Affichage des ItemArme et leur degats
        for (int i = 0; i < player.getGroupCreature().get(0).inventory().getSize(); i++){
            terminal.write(joueur.inventory().get(i).getName(), 3, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
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

        if (joueur.inventory().getSize() >= 1) {
            terminal.writeCenter("Press [D] to drop current item", 41, Color.GRAY);
        }
    }

//    public static void afficheMenuItem(AsciiPanel terminal, InventoryScreen menu){
//
//    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_I:
                return new PlayScreen(world, player, groupCreature);
            case KeyEvent.VK_DOWN:
                if (pos != (player.getGroupCreature().get(0).inventory().getSize()) - 1){
                    this.pos++;
                }
                return this;
            case KeyEvent.VK_UP:
                if (pos != 0){
                    this.pos--;
                }
                return this;
            case KeyEvent.VK_D:
                if (world.tile(player.x, player.y) == Tile.FLOOR && world.item(player.x, player.y) == null && pos >= 0){
                    return new DropItemScreen(groupCreature,player,world,pos);
                } else return this;
        }
        return this;
    }
}