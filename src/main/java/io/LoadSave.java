package io;

import Tiles.Tile;
import creature.*;
import creature.pj.Guerrier;
import creature.pj.Mage;
import object.items.*;
import screens.PlayScreen;
import world.World;
import world.WorldBuilder;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.exit;

/**
 * Classe de la chargement de la Sauvegarde
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class LoadSave {
    /**
     * Sauvegarde les tiles.
     */
    private Tile[][] tiles;

    /**
     * Sauvegarde les items.
     */
    private Item[][] items;

    /**
     * Sauvegarde les emplacements de chaque item.
     */
    private ArrayList<Point> itemPointList;

    /**
     * Sauvegarde l'emplacement du player.
     */
    private Point pt;

    /**
     * Sauvegarde l'emplacement du villageoi.
     */
    private Point ptSpawn;

    /**
     * Sauvegarde la liste de monstres sur la map.
     */
    private ArrayList<Point> listMonster;

    /**
     * Sauvegarde la player.
     */
    private GroupCreature player;

    /**
     * Sauvegarde la liste de toutes les créatures.
     */
    private ArrayList<GroupCreature> groupCreature;

    /**
     * Sauvegarde la largeur de la Map
     */
    private int width;

    /**
     * Sauvegarde la Hauteur de la Map.
     */
    private int height;

    /**
     * Sauvegarde le world.
     */
    private World world;

    /**
     * Sauvgarde la world du village.
     */
    private World village;

    /**
     * Sauvegarde un possibilité d'erreur.
     */
    private int error;

    /**
     * Constructeur par défaut du chargement de la sauvegarde.
     */
    public LoadSave(){
        this.width = 100;
        this.height = 100;
        this.error = 0;
        loadTile();
        loadPlayer();
        loadItem();
        loadMonster();

        this.world = new World(tiles, pt, ptSpawn, items, listMonster);
        this.village = new WorldBuilder(100	, 100).buildVillage();


        groupCreature = new ArrayList<GroupCreature>();
        CreatureFactory creatureFactory = new CreatureFactory(world);
        for(int i = 0 ; i<listMonster.size();i++){
            Point p = listMonster.get(i);
            groupCreature.add(creatureFactory.newMonster((int)p.getY(),(int)p.getX()));
        }
    }

    /**
     * Permet de tester si la sauvegarde a été dégradée.
     * Si c'est le cas alors toute la sauvegarde est supprimer et vous recommencez du début.
     * Sinon elle lance le jeux tout a fait normalement.
     * @return un play Screen
     */
    public PlayScreen PlayScreen(){
        if(error == 1){
            System.err.println();
            System.err.println();
            System.err.println("        The new part started backup does not exist or is corrupt");
            return new PlayScreen(new Guerrier("Bob",30,5));
        }
        return new PlayScreen(world, village, player, groupCreature);
    }

    /**
     * Permet de charger les tiles.
     */
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
                            tiles[j][i] = Tile.FLOOR;
                            break;
                        case (char)177:
                            //System.out.print((char)177);
                            tiles[j][i] = Tile.WALL;
                            break;
                        case 'o':
                            //System.out.print((char)244);
                            tiles[j][i] = Tile.ITEMS;
                            break;
                        case (char)79:
                            //System.out.print((char)79);
                            tiles[j][i] = Tile.EXIT;
                            break;
                        case (char) 86:
                            //System.out.print((char)79);
                            tiles[j][i] = Tile.VILLAGEPORTAL;
                            break;
                        case 'x':
                            //System.out.print('x');
                            tiles[j][i] = Tile.BOUNDS;
                            break;
                        case (char)251:
                            //System.out.print((char)250);
                            tiles[j][i] = Tile.FLOORALREADYVISITED;
                            break;
                        case (char)178:
                            //System.out.print((char)177);
                            tiles[j][i] = Tile.WALLUNKNOW;
                            break;
                        case (char)179:
                            //System.out.print((char)177);
                            tiles[j][i] = Tile.WALLALREADYVISITED;
                            break;
                        case (char)80:
                            //System.out.print((char)79);
                            tiles[j][i] = Tile.EXITUNKNOW;
                            break;
                        case (char)87:
                            //System.out.print((char)79);
                            tiles[j][i] = Tile.VILLAGEPORTALUNKNOW;
                            break;
                        case (char)88:
                            //System.out.print((char)79);
                            tiles[j][i] = Tile.VILLAGEPORTALALREADYVISITED;
                            break;
                        case (char)81:
                            //System.out.print((char)79);
                            tiles[j][i] = Tile.EXITALREADYVISITED;
                            break;
                        case 'p':
                            //System.out.print('o');
                            tiles[j][i] = Tile.ITEMSUNKNOW;
                            break;
                        case 'q':
                            //System.out.print('o');
                            tiles[j][i] = Tile.ITEMALREADYVISITED;
                            //System.out.println("test");
                            break;
                        case (char)252:
                            //System.out.print((char)250);
                            tiles[j][i] = Tile.FLOORUNKNOW;
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
            error =1;
        }
    }

    /**
     * Permet de charger les items.
     */
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
                        itemPointList.add(new Point(Integer.parseInt(sep[2]),Integer.parseInt(sep[1])));
                        items[Integer.parseInt(sep[1])][Integer.parseInt(sep[2])] = new ItemArme((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5]),Integer.parseInt(sep[9]));
                        //tem.out.println(Integer.parseInt(sep[1]) + " " + Integer.parseInt(sep[2]));
                        break;
                    case "2" :
                        itemPointList.add(new Point(Integer.parseInt(sep[2]),Integer.parseInt(sep[1])));
                        items[Integer.parseInt(sep[1])][Integer.parseInt(sep[2])] = new ItemEquipementArmure((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5]),Integer.parseInt(sep[9]));
                        //System.out.println(Integer.parseInt(sep[1]) + " " + Integer.parseInt(sep[2]));

                        break;
                    case "3" :
                        itemPointList.add(new Point(Integer.parseInt(sep[2]),Integer.parseInt(sep[1])));
                        items[Integer.parseInt(sep[1])][Integer.parseInt(sep[2])] = new ItemEquipementBotte((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5]),Integer.parseInt(sep[9]));
                        //System.out.println(Integer.parseInt(sep[1]) + " " + Integer.parseInt(sep[2]));

                        break;
                    case "4" :
                        itemPointList.add(new Point(Integer.parseInt(sep[2]),Integer.parseInt(sep[1])));
                        items[Integer.parseInt(sep[1])][Integer.parseInt(sep[2])] = new ItemPotion((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5]),Integer.parseInt(sep[9]));
                        //System.out.println(Integer.parseInt(sep[1]) + " " + Integer.parseInt(sep[2]));

                        break;
                    case "5" :
                        itemPointList.add(new Point(Integer.parseInt(sep[2]),Integer.parseInt(sep[1])));
                        items[Integer.parseInt(sep[1])][Integer.parseInt(sep[2])] = new ItemEquipementCasque((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5]),Integer.parseInt(sep[9]));
                        //System.out.println(Integer.parseInt(sep[1]) + " " + Integer.parseInt(sep[2]));

                        break;
                    case "6" :
                        itemPointList.add(new Point(Integer.parseInt(sep[2]),Integer.parseInt(sep[1])));
                        items[Integer.parseInt(sep[1])][Integer.parseInt(sep[2])] = new ItemEquipementPantalon((char)Integer.parseInt(sep[3]), new Color(Integer.parseInt(sep[8]),Integer.parseInt(sep[6]),Integer.parseInt(sep[7])), sep[4], Integer.parseInt(sep[5]),Integer.parseInt(sep[9]));
                        //System.out.println(Integer.parseInt(sep[1]) + " " + Integer.parseInt(sep[2]));

                        break;
                }

            }
            fichier.close();
        }catch (IOException e) {
            e.printStackTrace();
            error =1;
        }
    }

    /**
     * Permet de charger le player
     */
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
                            ItemArme itemA ;
                            itemA = new ItemArme(sep[1].charAt(0), new Color(Integer.parseInt(sep[3]),Integer.parseInt(sep[4]),Integer.parseInt(sep[2])), sep[5], Integer.parseInt(sep[6]),Integer.parseInt(sep[7]));
                            player.getGroupCreature().get(0).pickupItem(itemA);
                            if(sep[8].equals("true")){
                                player.getGroupCreature().get(0).inventory().setArmeEquipe(true);
                                itemA.setEquipe(true);
                            } else player.getGroupCreature().get(0).inventory().setArmeEquipe(false);
                            break;
                        case "2" :
                            ItemEquipementArmure itemAr ;
                            itemAr = new ItemEquipementArmure(sep[1].charAt(0), new Color(Integer.parseInt(sep[3]),Integer.parseInt(sep[4]),Integer.parseInt(sep[2])), sep[5], Integer.parseInt(sep[6]),Integer.parseInt(sep[7]));
                            player.getGroupCreature().get(0).pickupItem(itemAr);
                            if(sep[8].equals("true")) {
                                player.getGroupCreature().get(0).inventory().setArmureEquipe(true);
                                itemAr.setEquipe(true);
                            }
                            else player.getGroupCreature().get(0).inventory().setArmureEquipe(false);
                            break;
                        case "3" :
                            ItemEquipementBotte itemB ;
                            itemB = new ItemEquipementBotte(sep[1].charAt(0), new Color(Integer.parseInt(sep[3]),Integer.parseInt(sep[4]),Integer.parseInt(sep[2])), sep[5], Integer.parseInt(sep[6]),Integer.parseInt(sep[7]));
                            player.getGroupCreature().get(0).pickupItem(itemB);
                            if(sep[8].equals("true")) {
                                player.getGroupCreature().get(0).inventory().setBotteEquipe(true);
                                itemB.setEquipe(true);
                            }
                            else player.getGroupCreature().get(0).inventory().setBotteEquipe(false);
                            break;
                        case "4" :
                            player.getGroupCreature().get(0).pickupItem(new ItemPotion(sep[1].charAt(0), new Color(Integer.parseInt(sep[3]),Integer.parseInt(sep[4]),Integer.parseInt(sep[2])), sep[5], Integer.parseInt(sep[6]),Integer.parseInt(sep[7])));
                            break;
                        case "5" :
                            ItemEquipementCasque itemC ;
                            itemC = new ItemEquipementCasque(sep[1].charAt(0), new Color(Integer.parseInt(sep[3]),Integer.parseInt(sep[4]),Integer.parseInt(sep[2])), sep[5], Integer.parseInt(sep[6]),Integer.parseInt(sep[7]));
                            player.getGroupCreature().get(0).pickupItem(itemC);
                            if(sep[8].equals("true")){
                                player.getGroupCreature().get(0).inventory().setCasqueEquipe(true);
                                itemC.setEquipe(true);
                            }
                            else player.getGroupCreature().get(0).inventory().setCasqueEquipe(false);

                            break;
                        case "6" :
                            ItemEquipementPantalon itemP ;
                            itemP = new ItemEquipementPantalon(sep[1].charAt(0), new Color(Integer.parseInt(sep[3]),Integer.parseInt(sep[4]),Integer.parseInt(sep[2])), sep[5], Integer.parseInt(sep[6]),Integer.parseInt(sep[7]));
                            player.getGroupCreature().get(0).pickupItem(itemP);
                            if(sep[8].equals("true")) {
                                player.getGroupCreature().get(0).inventory().setPantalonEquipe(true);
                                itemP.setEquipe(true);
                            }
                            else player.getGroupCreature().get(0).inventory().setPantalonEquipe(false);

                            break;
                    }
                } else{
                    pt = new Point(Integer.parseInt(sep[0]),Integer.parseInt(sep[1]));
                    ptSpawn = new Point(Integer.parseInt(sep[2]),Integer.parseInt(sep[3]));
                    world = new World( tiles, pt, ptSpawn, items, listMonster);
                    CreatureFactory creatureFactory = new CreatureFactory(world);
                    switch (sep[7].charAt(0)){
                        case 'M' :
                            player = creatureFactory.newPlayer(new Mage());
                            break;
                        case 'G' :
                            player = creatureFactory.newPlayer(new Guerrier());
                            break;
                        default:;
                            player = creatureFactory.newPlayer(new Guerrier("Bob",30,5));
                            break;

                    }

                    player.getGroupCreature().get(0).setPointDeVie(Integer.parseInt(sep[5]));
                    player.getGroupCreature().get(0).setAttaque(Integer.parseInt(sep[6]));
                    player.getGroupCreature().get(0).setPointDeVieMax(Integer.parseInt(sep[4]));
                    player.getGroupCreature().get(0).setName(sep[8]);
                    player.getGroupCreature().get(0).setGlyph(sep[7].charAt(0));
                    player.getGroupCreature().get(0).setNiveau(Integer.parseInt(sep[13]));
                    player.getGroupCreature().get(0).inventory().setMonnaie(Integer.parseInt(sep[9]));

                    System.out.println(player.getGroupCreature().get(0).getPointDeVie());
                    System.out.println(player.getGroupCreature().get(0).getAttaque());
                    System.out.println(player.getGroupCreature().get(0).getPointDeVieMax());
                    System.out.println(player.getGroupCreature().get(0).getName());
                    System.out.println(player.getGroupCreature().get(0).getGlyph());
                    System.out.println(player.getGroupCreature().get(0).getNiveau());
                }
            }
            fichier.close();
        }catch (IOException e) {
            e.printStackTrace();
            error =1;
        }
    }

    /**
     * permet de charger les monstres.
     */
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
            error =1;
        }
    }

    /**
     * Getter Tile[][].
     * @return Tile[][]
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    /**
     * Getter Items[][].
     * @return Items[][]
     */
    public Item[][] getItems() {
        return items;
    }

    /**
     * Getter la player.
     * @return player
     */
    public GroupCreature getPlayer() {
        return player;
    }

    /**
     * Getter de la liste des monstres.
     * @return liste de monstres
     */
    public ArrayList<Point> getListMonster() {
        return listMonster;
    }
}