import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import world.World;
import world.WorldBuilder;

public class testMonster {
    World world;
    @BeforeAll
    public void Init(){
        this.world = new WorldBuilder(100	, 100).build();
    }
    @Test
    public void testNbMonster(){

    }
}
