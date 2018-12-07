package io;

import color.Tile;
import creature.Creature;
import creature.GroupCreature;
import object.Items.Item;
import screens.PlayScreen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Save {
    PlayScreen screen;
    GroupCreature player;
    ArrayList<Creature> creatures;
    ArrayList<GroupCreature> monster;

    public Save(PlayScreen screen){
        this.screen = screen;
        this.player =  screen.getPlayer();
        this.creatures = player.getGroupCreature();
        this.monster = screen.getGroupCreature();
        saveWorld();
        savePlayer();
        //saveMonster();
        //saveItem();
    }

    public void saveIventory(BufferedWriter writer){
        for (int i = 0; i < creatures.get(0).inventory().getSize(); i++) {
            try {
                writer.write(creatures.get(0).inventory().get(i).toString());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveWorld(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/world.txt"));
            Tile[][] tiles = screen.getWorld().getTiles();
            for (int i = 0; i < tiles.length; i++) {
                for (int j = 0; j < tiles.length; j++) {
                    switch (tiles[i][j]){
                        case FLOOR:
                            writer.write(".");
                            break;
                        case WALL:
                            writer.write((char)177);
                            break;
                        case ITEMS:
                            writer.write((char)244);
                            break;
                        case EXIT:
                            writer.write((char)79);
                            break;
                        case BOUNDS:
                            writer.write('x');
                            break;

                    }
                }
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savePlayer(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/player.txt"));
            writer.write(player.x + " " + player.y +" " );
            for (int i = 0; i<player.getGroupCreature().size();i++){
                writer.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVieMax()) + " ");
                writer.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVie())+ " ");
                writer.write(Integer.toString(player.getGroupCreature().get(i).getAttaque())+ " ");
                writer.write(player.getGroupCreature().get(i).getGlyph()+ " ");
                writer.write(player.getGroupCreature().get(i).getColor().getBlue()+ " "+player.getGroupCreature().get(i).getColor().getRed() + " "+player.getGroupCreature().get(i).getColor().getGreen());
                writer.newLine();
                saveIventory(writer);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveMonster(){
        for (int i = 0; i<monster.size();i++){
            System.out.println(monster.get(i).x + " " + monster.get(i).y +" " + (int)monster.get(i).glyph());
        }
    }

    public void saveItem(){
        Item[][] item = screen.getWorld().getItems();
        for (int i = 0; i < item.length; i++) {
            for (int j = 0; j < item.length; j++) {
                switch (item[i][j].getGlyph()){
                    case (char) 197:
                        System.out.println((char) 197 + i + " " + j );
                        break;
                    case (char) 179:
                        System.out.println((char) 179+ i + " " + j );
                        break;
                    case (char) 225:
                        System.out.println((char) 225 + i + " " + j );
                        break;
                    case (char) 190:
                        System.out.println((char) 190 + i + " " + j );
                        break;
                    case (char) 200:
                        System.out.println((char) 200 + i + " " + j );
                        break;
                }
            }
            System.out.println();
        }
    }
}
