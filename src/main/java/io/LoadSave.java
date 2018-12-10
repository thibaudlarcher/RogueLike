package io;

import color.Tile;
import creature.GroupCreature;
import object.Items.*;
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
        loadItem();
        loadMonster();

        //World word = new World(tiles, pt, items, listMonster);
        //PlayScreen screen = new PlayScreen(world, player, groupCreature);
    }

    private void loadTile(){
        tiles = new Tile[width][height];
        try{
            String str;
            int i = 0;
            BufferedReader fichier = new BufferedReader(new FileReader("src/main/resources/world.txt"));
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
        items = new Item[width][height];
        itemPointList = new ArrayList<>();
        try{
            String str;
            BufferedReader fichier = new BufferedReader(new FileReader("src/main/resources/item.txt"));
            while ((str = fichier.readLine()) != null) {
                String sep[]= str.split(" ");
                switch (sep[0]){
                    case "1" :
                        itemPointList.add(new Point(Integer.parseInt(sep[1]),Integer.parseInt(sep[2])));
                        items[Integer.parseInt(sep[0])][Integer.parseInt(sep[1])] = new ItemArme(sep[4].charAt(0), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[5], Integer.parseInt(sep[6]));
                        break;
                    case "2" :
                        itemPointList.add(new Point(Integer.parseInt(sep[1]),Integer.parseInt(sep[2])));
                        items[Integer.parseInt(sep[0])][Integer.parseInt(sep[1])] = new ItemEquipementArmure(sep[4].charAt(0), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[5], Integer.parseInt(sep[6]));
                        break;
                    case "3" :
                        itemPointList.add(new Point(Integer.parseInt(sep[1]),Integer.parseInt(sep[2])));
                        items[Integer.parseInt(sep[0])][Integer.parseInt(sep[1])] = new ItemEquipementBotte(sep[4].charAt(0), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[5], Integer.parseInt(sep[6]));
                        break;
                    case "4" :
                        itemPointList.add(new Point(Integer.parseInt(sep[1]),Integer.parseInt(sep[2])));
                        items[Integer.parseInt(sep[0])][Integer.parseInt(sep[1])] = new ItemPotion(sep[4].charAt(0), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[5], Integer.parseInt(sep[6]));
                        break;


                }

            }
            fichier.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPlayer(){
        try{
            String str;
            BufferedReader fichier = new BufferedReader(new FileReader("src/main/resources/player.txt"));
            while ((str = fichier.readLine()) != null) {
                String sep[]= str.split(" ");
                //if()
            }
            fichier.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMonster(){
        listMonster = new ArrayList<>();
        try{
            String str;
            int i = 0;
            BufferedReader fichier = new BufferedReader(new FileReader("src/main/resources/monster.txt"));
            while ((str = fichier.readLine()) != null) {
                String sep[]= str.split(" ");
                listMonster.add(new Point(Integer.parseInt(sep[0]),Integer.parseInt(sep[1])));
            }
            fichier.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//this.items = new Item[width+40][height];	// --> on prend le x max entre screenWidth et width et y max entre screenHeight et height