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
        Creature joueur = this.player.getGroupCreature().get(0);
        terminal.writeCenter("INVENTORY", 1, Color.WHITE);
        terminal.writeCenter("Taille : " + joueur.inventory().getSize() + "/" + joueur.inventory().getSizeMax(),2,Color.white);
        for (int j = 0; j < 140; j++){
            terminal.write((char) 196, j, 4, Color.WHITE);
            j++;
        }

        // Affichage des ItemArme et leur degats
        for (int i = 0; i < player.getGroupCreature().get(0).inventory().getSizeMax(); i++){
            if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "arme") {
                terminal.write(joueur.inventory().get(i).getName(), 3, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("degats: " + Integer.toString(joueur.inventory().get(i).getDammage()), 10, 6 + 2 * i, Color.GRAY);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "potion"){
                terminal.write(joueur.inventory().get(i).getName(), 3, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("soins: " + Integer.toString(joueur.inventory().get(i).getEffet()), 12, 6 + 2 * i, Color.GRAY);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "armure"){
                terminal.write(joueur.inventory().get(i).getName(), 3, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("defense: " + Integer.toString(joueur.inventory().get(i).getDefense()), 12, 6 + 2 * i, Color.GRAY);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "botte"){
                terminal.write(joueur.inventory().get(i).getName(), 3, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("defense: " + Integer.toString(joueur.inventory().get(i).getDefense()), 11, 6 + 2 * i, Color.GRAY);
            }
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
            if (world.tile(player.x,player.y) == Tile.ITEMS){
                terminal.writeCenter("You can't drop item here", 41, Color.RED);
            } else { terminal.writeCenter("Press [D] to drop current item", 41, Color.GRAY); }
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_I:
                return new PlayScreen(world, player, groupCreature);
            case KeyEvent.VK_DOWN:
                if (player.getGroupCreature().get(0).inventory().getSize() != 0) {
                    if (pos != (player.getGroupCreature().get(0).inventory().getIndiceMaxItem())) {
                        while (player.getGroupCreature().get(0).inventory().get(pos + 1) == null) {
                            this.pos++;
                        }
                        this.pos++;
                        System.out.println("pos : " + pos);
                    }
                }
                return this;
            case KeyEvent.VK_UP:
                if (pos != 0 && pos > -1) {
                    while (player.getGroupCreature().get(0).inventory().get(pos - 1) == null) {
                        this.pos--;
                        if (this.pos - 1 == -1){
                            this.pos = -1;
                            while (player.getGroupCreature().get(0).inventory().get(pos + 1) == null){
                                this.pos++;
                            }
                            this.pos = this.pos + 2;
                        }
                    }
                    this.pos--;
                    System.out.println("pos : " + pos);
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