import creature.PJ.Guerrier;
import io.LoadSave;
import io.Save;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import screens.PlayScreen;
import world.World;
import world.WorldBuilder;

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

    }

    @Test
    public void testSaveWorld(){

    }

    @Test
    public void testSaveMonster(){

    }

    @Test
    public void testSaveItem(){

    }
    @AfterAll
    public void testSaveItemNoSave(){

    }
    @AfterAll
    public void testSavePlayerNoSave(){

    }
    @AfterAll
    public void testSaveWorldNoSave(){

    }
    @AfterAll
    public void testSaveMonsterNoSave(){

    }
}
