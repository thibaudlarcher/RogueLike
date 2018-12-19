import Tiles.Tile;
import creature.GroupCreature;
import creature.PJ.Guerrier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import screens.PlayScreen;
import world.World;
import world.WorldBuilder;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testMonster {
    static World world;
    static PlayScreen screen;
    @BeforeAll
    public static void Init(){
        screen = new PlayScreen(new Guerrier("Guerrier",30,8));
        world = screen.getWorld();
    }
    @Test

    public void testNbMonster(){
        ArrayList<Point> monsterT = world.getListMonster();
        ArrayList<GroupCreature> listMonsterT = screen.getGroupCreature();
        boolean found = false;
        for(int i = 0 ; i < listMonsterT.size() ; i++){
            for(int j = 0 ; j < monsterT.size() ; j++){
                if(listMonsterT.get(i).x == monsterT.get(j).y && listMonsterT.get(i).y == monsterT.get(j).x ){
                    found = true;
                }
            }
            if(!found){
                assertTrue(false);
                return;
            }
            found = false;
        }

        assertTrue(true);
    }
}
