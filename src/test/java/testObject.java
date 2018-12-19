import creature.Creature;
import creature.pj.Guerrier;
import object.items.ItemArme;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import screens.PlayScreen;
import screens.village.VillageScreen;
import screens.village.VillageoisScreen;
import world.World;
import world.WorldBuilder;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class testObject {
    static Creature player;
    static ItemArme epee;
    static World village;
    static VillageoisScreen villageoisScreen;
    static VillageScreen villageScreen;
    static PlayScreen screen;

    @BeforeAll
    public static void Init(){
        screen = new PlayScreen(new Guerrier("Test", 20,5));
        player = screen.getPlayer().getGroupCreature().get(0);
        epee = new ItemArme('E', Color.GRAY,"epee", 15,20);
        village = new WorldBuilder(100, 100).buildVillage();
        villageScreen = new VillageScreen(screen, village);
        villageoisScreen = new VillageoisScreen(villageScreen);
    }

    @Test
    public void testCreationItem(){
        ItemArme epee = new ItemArme('E', Color.GRAY,"epee", 15,20);
        assertNotNull(epee);
    }

    @Test
    public void testAjoutItemInventaire(){
        player.inventory().add(epee);
        assertNotNull(player.inventory().get(0));
    }

    @Test
    public void testSuppressionItemInventaire(){
        player.inventory().add(epee);
        player.inventory().remove(epee);

        for (int i = 0; i < player.inventory().getSizeMax(); i++){
            if (player.inventory().get(i) == epee){
                assert false;
            }
        }
        assert true;
    }

    @Test
    public void testEquipeItem(){
        epee.setEquipe(true);
        assertTrue(epee.isEquipe());
    }

    @Test
    public void testMonnaie(){
        player.inventory().addMonnaie(10);
        assertEquals(10, player.inventory().getMonnaie());
    }

    // prix vente epee = 20
    // monnaie = 0 + 20 + 50 - 16 = 54
    @Test
    public void testVente(){
        player.inventory().add(epee);
        villageoisScreen.vendre(player.inventory().get(0));
        assertEquals(54, villageScreen.getPlayer().getGroupCreature().get(0).inventory().getMonnaie());
    }

    //prix potion = 16
    @Test
    public void testAchat(){
        villageScreen.getPlayer().getGroupCreature().get(0).inventory().setMonnaie(50);
        villageoisScreen.achatPotion();
        assertEquals(villageScreen.getPlayer().getGroupCreature().get(0).inventory().get(0).getType(), "potion");
    }

    @Test
    public void testInventaireFull(){
        for (int i = 0; i < 10; i++){
            player.inventory().add(epee);
        }
        assertTrue(player.inventory().isFull());
    }

    @Test
    public void testRemoveAllItemInventaire(){
        for (int i = 0; i < 10; i++){
            player.inventory().add(epee);
        }
        player.inventory().removeAllItem();
        assertFalse(player.inventory().isFull());
    }
}
