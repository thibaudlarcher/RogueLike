import Tiles.Tile;
import creature.GroupCreature;
import creature.pj.Guerrier;
import io.LoadSave;
import io.Save;
import object.items.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import screens.PlayScreen;
import world.World;
import world.WorldBuilder;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class testInputGuerrier {
    static World world;
    static PlayScreen screen;
    static LoadSave load;
    @BeforeAll
    public static void testWorld(){
        world = new WorldBuilder(100	, 100).build();
        screen = new PlayScreen(new Guerrier("Guerrier",30,8));
        new Save(screen);
        load = new LoadSave();
    }

    @Test
    public void testSavePlayer(){
        GroupCreature playerW =  screen.getPlayer();
        GroupCreature playerL =  load.getPlayer();
        assertEquals(playerL.x,playerW.x);
        assertEquals(playerL.y,playerW.y);
        assertEquals(playerL.glyph(),playerW.glyph());
        assertEquals(playerL.getColor(),playerW.getColor());
        assertEquals(playerL.getGroupCreature().get(0).getPointDeVie(),playerW.getGroupCreature().get(0).getPointDeVie());
        assertEquals(playerL.getGroupCreature().get(0).getPointDeVieMax(),playerW.getGroupCreature().get(0).getPointDeVieMax());
        assertEquals(playerL.getGroupCreature().get(0).getAttaque(),playerW.getGroupCreature().get(0).getAttaque());
        assertEquals(playerL.getGroupCreature().get(0).getNiveau(),playerW.getGroupCreature().get(0).getNiveau());
        assertEquals(playerL.getGroupCreature().get(0).getDefense(),playerW.getGroupCreature().get(0).getDefense());
        for(int i = 0 ; i < playerW.getGroupCreature().get(0).inventory().getSize() ; i++) {
            assertEquals(playerW.getGroupCreature().get(0).inventory().getItems()[i],playerW.getGroupCreature().get(0).inventory().getItems()[i]);
        }
    }

    @Test
    public void testSaveWorld(){
        Tile[][] TilesL = load.getTiles();
        Tile[][] TilesW = screen.getWorld().getTiles();
        for(int i = 0 ; i < world.height() ; i++){
            for(int j = 0 ; j < world.height() ; j++){
                assertEquals(TilesL[i][j],TilesW[i][j]);
            }
        }
    }

    @Test
    public void testSaveMonster(){

        ArrayList<Point> monsterL = load.getListMonster();
        boolean found = false;
        for(int i = 0 ; i < monsterL.size() ; i++){
            for(int j = 0 ; j < screen.getGroupCreature().size() ; j++){
                System.out.println(monsterL.get(i).x + " " + screen.getGroupCreature().get(j).x + " " + monsterL.get(i).y + " " + screen.getGroupCreature().get(j).y);
                if(monsterL.get(i).x == screen.getGroupCreature().get(j).y && monsterL.get(i).y == screen.getGroupCreature().get(j).x ){
                    found = true;
                }
            } if(!found){
                assertTrue(false);
                return;
            }
            found = false;
        }
        assertTrue(true);
    }


    @Test
    public void testSaveItem(){
        Item[][] itemsW = world.getItems();
        Item[][] itemsL = world.getItems();
        for (int i = 0 ; i<world.height();i++){
            for (int j = 0 ; j<world.height();j++){
                assertEquals(itemsL[i][j],itemsW[i][j]);
            }
        }

    }
}
