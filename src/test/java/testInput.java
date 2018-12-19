import Tiles.Tile;
import creature.GroupCreature;
import creature.PJ.Guerrier;
import io.LoadSave;
import io.Save;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import screens.PlayScreen;
import world.World;
import world.WorldBuilder;
import static org.junit.jupiter.api.Assertions.*;
public class testInput {
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

    }

    @Test
    public void testSaveItem(){

    }
}
