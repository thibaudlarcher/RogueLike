package io;

import Tiles.Tile;
import creature.Creature;
import creature.GroupCreature;
import object.Items.Item;
import screens.PlayScreen;
import screens.Village.VillageScreen;
import world.World;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe de la Sauvegarde
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class Save {
    /**
     * Stocket un play screen.
     */
    PlayScreen screen;

    /**
     * Permet de stocket un player.
     */
    GroupCreature player;

    /**
     * Permet de stocker les créatures.
     */
    ArrayList<Creature> creatures;

    /**
     * Permet de stocker les monstres.
     */
    ArrayList<GroupCreature> monster;

    /**
     * Constructeur de la classe save
     * @param screen PlayScreen
     */
    public Save(PlayScreen screen){
        this.screen = screen;
        this.player =  screen.getPlayer();
        this.creatures = player.getGroupCreature();
        this.monster = screen.getGroupCreature();
        saveWorld();
        savePlayer();
        saveMonster();
        saveItem();
//        saveItemVillage();
    }

    /**
     * On sauvegarde l'inventaire du personnages.
     * @param writer L'inventaire
     */
    public void saveIventory(BufferedWriter writer){
        for (int i = 0; i < creatures.get(0).inventory().getSize(); i++) {
            try {
                if (creatures.get(0).inventory().get(i) != null) {
                    writer.write(creatures.get(0).inventory().get(i).toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * On sauvegarde le monde.
     */
    public void saveWorld(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/world.txt"));
            Tile[][] tiles = screen.getWorld().getTiles();
            for (int j = 0; j < tiles.length; j++) {
                for (int i = 0; i < tiles[j].length; i++) {
                    switch (tiles[i][j]){
                        case FLOOR:
                            //System.out.print('.');
                            writer.write(".");
                            break;
                        case WALL:
                            //System.out.print((char)177);
                            writer.write((char)177);
                            break;
                        case ITEMS:
                           // System.out.print('o');
                            writer.write('o');
                            break;
                        case EXIT:
                            //System.out.print((char)79);
                            writer.write((char)79);
                            break;
                        case VILLAGEPORTAL:
                            //System.out.print('V');
                            writer.write((char) 86);
                            break;
                        case BOUNDS:
                            //System.out.print('x');
                            writer.write('x');
                            break;
                        case FLOORALREADYVISITED:
                           //System.out.print((char)251);
                            writer.write((char)251);
                            break;
                        case WALLUNKNOW:
                           // System.out.print((char)178);
                            writer.write((char)178);
                            break;
                        case WALLALREADYVISITED:
                            //System.out.print((char)179);
                            writer.write((char)179);
                            break;
                        case EXITUNKNOW:
                            //System.out.print((char)80);
                            writer.write((char)80);
                            break;
                        case EXITALREADYVISITED:
                            //System.out.print((char)81);
                            writer.write((char)81);
                            break;
                        case ITEMSUNKNOW:
                            //System.out.print('p');
                            writer.write('p');
                            break;
                        case ITEMALREADYVISITED:
                            //System.out.print('q');
                            writer.write('q');
                            break;
                        case FLOORUNKNOW:
                            //System.out.print((char)252);
                            writer.write((char)252);
                            break;
                        case VILLAGEPORTALUNKNOW:
                            //System.out.print((char)87);
                            writer.write((char)87);
                            break;
                        case VILLAGEPORTALALREADYVISITED:
                            //System.out.print((char)88);
                            writer.write((char)88);
                            break;
                        default:
                            //System.out.print("Unknow caractere");
                            writer.write('x');

                    }
                }
                //System.out.println();
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * On sauvegarde le player.
     */
    public void savePlayer(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/player.txt"));
            writer.write(player.x + " " + player.y +" " );
            writer.write(screen.getWorld().getPtSpawn().x + " " + screen.getWorld().getPtSpawn().y +" " );
            for (int i = 0; i<player.getGroupCreature().size();i++){
                writer.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVieMax()) + " ");
                writer.write(Integer.toString(player.getGroupCreature().get(i).getPointDeVie())+ " ");
                writer.write(Integer.toString(player.getGroupCreature().get(i).getAttaque())+ " ");
                writer.write(player.getGroupCreature().get(i).getGlyph()+ " ");
                writer.write(player.getGroupCreature().get(i).getName()+ " ");
                writer.write(player.getGroupCreature().get(i).getColor().getBlue()+ " "+player.getGroupCreature().get(i).getColor().getRed() + " "+player.getGroupCreature().get(i).getColor().getGreen());
                writer.newLine();
                writer.write("<Inventory>");
                writer.newLine();
                saveIventory(writer);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * On sauvegarde les Monstres.
     */
    public void saveMonster(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/monster.txt"));
            for (int i = 0; i<monster.size();i++){
                writer.write(monster.get(i).x + " " + monster.get(i).y +" " + monster.get(i).glyph());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * On sauvegarde les items sur la Map.
     */
    public void saveItem(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/item.txt"));
            Item[][] item = screen.getWorld().getItems();
            for (int i = 0; i < item.length; i++) {
                for (int j = 0; j < item[i].length; j++) {
                    if(item[i][j]!=null) {
                        switch (item[i][j].getGlyph()) {
                            case (char) 197:
                                writer.write(1  + " " + i + " " + j + " " + 197 + " " + item[i][j].getName() + " " + item[i][j].getDammage()  + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + "false") ;
                                break;
                            case (char) 179:
                                writer.write(1 + " " + i + " " + j + " " + 179 + " " + item[i][j].getName() + " " + item[i][j].getDammage() + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + "false") ;
                                break;
                            case (char) 225:
                                writer.write(4 + " " + i + " " + j + " " + 225 + " " + item[i][j].getName() + " " + item[i][j].getEffet()  + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + "false") ;
                                break;
                            case (char) 190:
                                writer.write(2 + " " + i + " " + j + " " + 190 + " " + item[i][j].getName() + " " + item[i][j].getDefense()  + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + "false") ;
                                break;
                            case (char) 200:
                                writer.write(3 + " " + i + " " + j + " " + 200 + " " + item[i][j].getName() + " " + item[i][j].getDefense()  + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + item[i][j].getValeur() + " " + "false") ;
                                break;
                            case  (char) 94:
                                writer.write(5 + " " + i + " " + j + " " + 94 + " " + item[i][j].getName() + " " + item[i][j].getDefense()  + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + "false") ;
                                break;
                            case (char) 186:
                                writer.write(6 + " " + i + " " + j + " " + 186 + " " + item[i][j].getName() + " " + item[i][j].getDefense()  + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + "false") ;
                                break;
                            case (char) 254:
                                writer.write(7 + " " + i + " " + j + " " + 254 + " " + item[i][j].getName() + " " + item[i][j].getDefense()  + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + "false") ;
                                break;
                            default:
                                break;
                        }
                        writer.newLine();
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void saveItemVillage(){
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/itemVillage.txt"));
//            Item[][] item = screen.getVillage().getItems();
//            for (int i = 0; i < item.length; i++) {
//                for (int j = 0; j < item[i].length; j++) {
//                    if(item[i][j]!=null) {
//                        switch (item[i][j].getGlyph()) {
//                            case (char) 197:
//                                writer.write(1  + " " + i + " " + j + " " + 197 + " " + item[i][j].getName() + " " + item[i][j].getDammage()  + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + "false") ;
//                                break;
//                            case (char) 179:
//                                writer.write(1 + " " + i + " " + j + " " + 179 + " " + item[i][j].getName() + " " + item[i][j].getDammage() + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + "false") ;
//                                break;
//                            case (char) 225:
//                                writer.write(4 + " " + i + " " + j + " " + 225 + " " + item[i][j].getName() + " " + item[i][j].getEffet()  + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + "false") ;
//                                break;
//                            case (char) 190:
//                                writer.write(2 + " " + i + " " + j + " " + 190 + " " + item[i][j].getName() + " " + item[i][j].getDefense()  + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + "false") ;
//                                break;
//                            case (char) 200:
//                                writer.write(3 + i + " " + j + " " + 200 + " " + item[i][j].getName() + " " + item[i][j].getDefense()  + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + item[i][j].getValeur() + " " + "false") ;
//                                break;
//                            case  (char) 94:
//                                writer.write(5 + i + " " + j + " " + 200 + " " + item[i][j].getName() + " " + item[i][j].getDefense()  + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + "false") ;
//                                break;
//                            case (char) 186:
//                                writer.write(6 + i + " " + j + " " + 200 + " " + item[i][j].getName() + " " + item[i][j].getDefense()  + " " + item[i][j].getColor().getGreen() + " " + item[i][j].getColor().getBlue() + " " + item[i][j].getColor().getRed() + " " + item[i][j].getValeur() + " " + "false") ;
//                                break;
//                            default:
//                                break;
//                        }
//                        writer.newLine();
//                    }
//                }
//            }
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
