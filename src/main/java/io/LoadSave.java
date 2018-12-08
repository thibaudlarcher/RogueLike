package io;

import color.Tile;
import creature.GroupCreature;
import object.Items.Item;
import screens.PlayScreen;
import world.World;
import world.WorldBuilder;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadSave {

    private Tile[][] tiles;
    private Item[][] items;
    private ArrayList<Point> itemPointList;
    private Point pt;
    private ArrayList<Point> listMonster;
    private GroupCreature player;
    private ArrayList<GroupCreature> groupCreature;
    private int width;
    private int height;


    public LoadSave(){
        this.width = 100;
        this.height = 100;
        loadTile();
        //loadPlayer();
        //loadItem();
        //loadMonster();

        //World word = new World(tiles, pt, items, listMonster);
        //PlayScreen screen = new PlayScreen(world, player, groupCreature);
    }

    private void loadTile(){
        Tile[][] tiles = new Tile[width][height];
        try{
            String str;
            int i = 0;
            BufferedReader fichier = new BufferedReader(new FileReader("src/main/java/world.txt"));
            while ((str = fichier.readLine()) != null) {
                for(int j = 0;j<str.length();j++){
                    switch (str.charAt(i)){
                        case '.':
                            tiles[i][j] = Tile.FLOOR;
                            break;
                        case (char)177:
                            tiles[i][j] = Tile.WALL;
                            break;
                        case (char)244:
                            tiles[i][j] = Tile.ITEMS;
                            break;
                        case (char)79:
                            tiles[i][j] = Tile.EXIT;
                            break;
                        case 'x':
                            tiles[i][j] = Tile.BOUNDS;
                            break;
                    }
                }
                i++;
            }
            fichier.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadItem(){

    }

    private void loadPlayer(){

    }

    private void loadMonster(){

    }
}


//this.items = new Item[width+40][height];	// --> on prend le x max entre screenWidth et width et y max entre screenHeight et height