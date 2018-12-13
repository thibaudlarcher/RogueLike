package screens.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import asciiPanel.AsciiPanel;
import Tiles.Tile;
import creature.Creature;
import creature.GroupCreature;
import screens.MenuScreen;
import screens.PlayScreen;
import screens.Screen;
import world.World;

public class InventoryScreen implements Screen {
    private PlayScreen screen;
    private World world;
    private ArrayList<GroupCreature> groupCreature;
    private GroupCreature player;
    private int pos;

    public InventoryScreen (PlayScreen screen){
        this.screen = screen;
        this.player = screen.getPlayer();
        this.world = screen.getWorld();
        this.groupCreature = screen.getGroupCreature();
        this.pos = -1;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.setDefaultBackgroundColor(new Color(24, 75, 123));
        terminal.clear();
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
                terminal.write("Cette redoutable arme vous offrira " + Integer.toString(joueur.inventory().get(i).getDammage()) + " de degats face aux monstres.", 14, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "potion"){
                terminal.write(joueur.inventory().get(i).getName(), 3, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Cette potion vous soignera de " + Integer.toString(joueur.inventory().get(i).getEffet()) + " points de vie.", 14, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "armure"){
                terminal.write(joueur.inventory().get(i).getName(), 3, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Cette robuste armure vous offrira " + Integer.toString(joueur.inventory().get(i).getDefense()) + " de defense face aux monstres.", 14, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "botte"){
                terminal.write(joueur.inventory().get(i).getName(), 3, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Cette paire de bottes vous offrira " + Integer.toString(joueur.inventory().get(i).getDefense()) + " de defense face aux monstres.", 14, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "casque") {
                terminal.write(joueur.inventory().get(i).getName(), 3, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Ce simple casque vous offrira " + Integer.toString(joueur.inventory().get(i).getDefense()) + " de defense face aux monstres.", 14, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
            } else if (joueur.inventory().get(i) != null && joueur.inventory().get(i).getType() == "pantalon") {
                terminal.write(joueur.inventory().get(i).getName(), 3, 6 + 2 * i, this.pos == i ? Color.yellow : Color.white);
                terminal.write("Ce long pantalon vous offrira " + Integer.toString(joueur.inventory().get(i).getDefense()) + " de defense face aux monstres.", 14, 6 + 2 * i, this.pos == i ? Color.yellow : Color.GRAY);
            }
        }

        if (joueur.inventory().getSize() >= 1) {
            if (world.tile(player.x,player.y) == Tile.ITEMS){
                terminal.writeCenter("You can't drop item here", 41, Color.RED);
            } else { terminal.writeCenter("Press [D] to drop current item", 41, Color.GRAY); }
        }
        terminal.write("Menu [R]", 0,40,Color.white);
        terminal.write("Jeux [ESC]", 130,40,Color.white);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_R:
                return new MenuScreen(screen);
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
                    return new DropItemScreen(screen,pos);
                } else return this;
        }
        return this;
    }
}