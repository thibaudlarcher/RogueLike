package io;

import Tiles.Tile;
import creature.*;
import object.Items.*;
import screens.PlayScreen;
import world.World;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.exit;

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
    private World world;


    public LoadSave(){
        this.width = 100;
        this.height = 100;
        loadTile();
        loadPlayer();
        loadItem();
        loadMonster();

        this.world = new World(tiles, pt, items, listMonster);

        groupCreature = new ArrayList<GroupCreature>();
        CreatureFactory creatureFactory = new CreatureFactory(world);
        for(int i = 0 ; i<listMonster.size();i++){
            Point p = listMonster.get(i);
            groupCreature.add(creatureFactory.newMonster((int)p.getY(),(int)p.getX()));
        }
    }

    public PlayScreen Test(){
        return new PlayScreen(world, player, groupCreature);
    }

    private void loadTile(){
        tiles = new Tile[width][height];
        try{
            String str;
            int i = 0;
            BufferedReader fichier = new BufferedReader(new FileReader("src/main/resources/world.txt"));
            while ((str = fichier.readLine()) != null) {
                for(int j = 0;j<str.length();j++){
                    switch (str.charAt(j)){
                        case '.':
                            //System.out.print('.');
                            tiles[i][j] = Tile.FLOOR;
                            break;
                        case (char)177:
                            //System.out.print((char)177);
                            tiles[i][j] = Tile.WALL;
                            break;
                        case (char)244:
                            //System.out.print((char)244);
                            tiles[i][j] = Tile.ITEMS;
                            break;
                        case (char)79:
                            //System.out.print((char)79);
                            tiles[i][j] = Tile.EXIT;
                            break;
                        case 'x':
                            //System.out.print('x');
                            tiles[i][j] = Tile.BOUNDS;
                            break;
                        case (char)251:
                            //System.out.print((char)250);
                            tiles[i][j] = Tile.FLOORALREADYVISITED;
                            break;
                        case (char)178:
                            //System.out.print((char)177);
                            tiles[i][j] = Tile.WALLUNKNOW;
                            break;
                        case (char)179:
                            //System.out.print((char)177);
                            tiles[i][j] = Tile.WALLALREADYVISITED;
                            break;
                        case (char)80:
                            //System.out.print((char)79);
                            tiles[i][j] = Tile.EXITUNKNOW;
                             break;
                        case (char)81:
                            //System.out.print((char)79);
                            tiles[i][j] = Tile.EXITALREADYVISITED;
                            break;
                        case 'o':
                            //System.out.print('o');
                            tiles[i][j] = Tile.ITEMSUNKNOW;
                            break;
                        case 'p':
                            //System.out.print('o');
                            tiles[i][j] = Tile.ITEMALREADYVISITED;
                            break;
                        case (char)252:
                            //System.out.print((char)250);
                            tiles[i][j] = Tile.FLOORUNKNOW;
                            break;
                        default:
                            exit(1);
                    }
                }
                //System.out.println();
                i++;
            }
            //System.out.println(i);
            fichier.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadItem(){
        items = new Item[width+40][height];
        itemPointList = new ArrayList<>();
        try{
            String str;
            BufferedReader fichier = new BufferedReader(new FileReader("src/main/resources/item.txt"));
            while ((str = fichier.readLine()) != null) {
                String sep[]= str.split(" ");
                switch (sep[0]){
                    case "1" :
                        itemPointList.add(new Point(Integer.parseInt(sep[1]),Integer.parseInt(sep[2])));
                        items[Integer.parseInt(sep[1])][Integer.parseInt(sep[2])] = new ItemArme((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5]));
                        break;
                    case "2" :
                        itemPointList.add(new Point(Integer.parseInt(sep[1]),Integer.parseInt(sep[2])));
                        items[Integer.parseInt(sep[1])][Integer.parseInt(sep[2])] = new ItemEquipementArmure((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5]));
                        break;
                    case "3" :
                        itemPointList.add(new Point(Integer.parseInt(sep[1]),Integer.parseInt(sep[2])));
                        items[Integer.parseInt(sep[1])][Integer.parseInt(sep[2])] = new ItemEquipementBotte((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5]));
                        break;
                    case "4" :
                        itemPointList.add(new Point(Integer.parseInt(sep[1]),Integer.parseInt(sep[2])));
                        items[Integer.parseInt(sep[1])][Integer.parseInt(sep[2])] = new ItemPotion((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5]));
                        break;
                    case "5" :
                        itemPointList.add(new Point(Integer.parseInt(sep[1]),Integer.parseInt(sep[2])));
                        items[Integer.parseInt(sep[1])][Integer.parseInt(sep[2])] = new ItemEquipementCasque((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5]));
                        break;
                    case "6" :
                        itemPointList.add(new Point(Integer.parseInt(sep[1]),Integer.parseInt(sep[2])));
                        items[Integer.parseInt(sep[1])][Integer.parseInt(sep[2])] = new ItemEquipementPantalon((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5]));
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
            boolean inv = false;
            BufferedReader fichier = new BufferedReader(new FileReader("src/main/resources/player.txt"));
            while ((str = fichier.readLine()) != null) {
                String sep[]= str.split(" ");
                if(sep[0].equals("<Inventory>" )) {
                    inv = true;
                } else if(inv){
                    switch (sep[0]){
                        case "1" :
                            player.getGroupCreature().get(0).pickupItem(new ItemArme(sep[1].charAt(0), new Color(Integer.parseInt(sep[3]),Integer.parseInt(sep[4]),Integer.parseInt(sep[2])), sep[5], Integer.parseInt(sep[6])));
                            break;
                        case "2" :
                            player.getGroupCreature().get(0).pickupItem(new ItemEquipementArmure(sep[1].charAt(0), new Color(Integer.parseInt(sep[3]),Integer.parseInt(sep[4]),Integer.parseInt(sep[2])), sep[5], Integer.parseInt(sep[6])));
                            break;
                        case "3" :
                            player.getGroupCreature().get(0).pickupItem(new ItemEquipementBotte(sep[1].charAt(0), new Color(Integer.parseInt(sep[3]),Integer.parseInt(sep[4]),Integer.parseInt(sep[2])), sep[5], Integer.parseInt(sep[6])));
                            break;
                        case "4" :
                            player.getGroupCreature().get(0).pickupItem(new ItemPotion(sep[1].charAt(0), new Color(Integer.parseInt(sep[3]),Integer.parseInt(sep[4]),Integer.parseInt(sep[2])), sep[5], Integer.parseInt(sep[6])));
                            break;
                        case "5" :
                            player.getGroupCreature().get(0).pickupItem(new ItemEquipementCasque((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5])));
                            break;
                        case "6" :
                            player.getGroupCreature().get(0).pickupItem(new ItemEquipementPantalon((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5])));
                            break;
                    }
                } else{
                    pt = new Point(Integer.parseInt(sep[0]),Integer.parseInt(sep[1]));
                    world = new World( tiles, pt, items, listMonster);
                    CreatureFactory creatureFactory = new CreatureFactory(world);
                    player = creatureFactory.newPlayer();
                    player.getGroupCreature().get(0).setPointDeVie(Integer.parseInt(sep[3]));
                    player.getGroupCreature().get(0).setAttaque(Integer.parseInt(sep[4]));
                    player.getGroupCreature().get(0).setPointDeVieMax(Integer.parseInt(sep[2]));
                    player.getGroupCreature().get(0).setName(sep[6]);
                    player.getGroupCreature().get(0).setGlyph(sep[5].charAt(0));
                }
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
            BufferedReader fichier = new BufferedReader(new FileReader("src/main/resources/monster.txt"));
            while ((str = fichier.readLine()) != null) {
                String sep[]= str.split(" ");
                listMonster.add(new Point(Integer.parseInt(sep[1]),Integer.parseInt(sep[0])));
            }
            fichier.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//this.items = new Item[width+40][height];	// --> on prend le x max entre screenWidth et width et y max entre screenHeight et height