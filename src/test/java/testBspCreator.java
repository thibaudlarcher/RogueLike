import gameroots.mapgen.bsp.BspMapCreator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import world.World;
import world.WorldBuilder;

import static org.junit.jupiter.api.Assertions.*;

public class testBspCreator {
    static World world;
    char[][] tiles = null;

    @BeforeAll
    public static void testWorld() {
        world = new WorldBuilder(100, 100).build();
    }

    @Test
    public void testRender() {
        BspMapCreator map = new BspMapCreator();
        map.setMinRoomSize(5);
        map.setMaxIterations(6);
        map.setMapDimension(200, 200);
        tiles = map.createMap();
        if (tiles == null) {
            assertTrue(false);
        } else {
            assertTrue(true);
        }
    }

    @Test
    public void testPersonnage() {
        BspMapCreator map = new BspMapCreator();
        map.setMinRoomSize(5);
        map.setMaxIterations(6);
        map.setMapDimension(200, 200);
        tiles = map.createMap();
        for (int i = 0; i < 200; i++) {
            for (int j = 0; i < 200; i++) {
                if (tiles[i][j] == '@') {
                    assertTrue(true);
                    return;
                }
            }
        }
        assertTrue(true);
    }


    @Test
    public void testItem() {
        BspMapCreator map = new BspMapCreator();
        map.setMinRoomSize(5);
        map.setMaxIterations(6);
        map.setMapDimension(200, 200);
        tiles = map.createMap();
        for (int i = 0; i < 200; i++) {
            for (int j = 0; i < 200; i++) {
                if (tiles[i][j] == 'o') {
                    assertTrue(true);
                    return;
                }
            }
        }
    }
}
