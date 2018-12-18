import creature.Creature;
import creature.PJ.Guerrier;
import object.Items.ItemArme;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class testObject {
    static Creature player;
    static ItemArme epee;

    @BeforeAll
    public static void Init(){
        player = new Guerrier("Test", 20,5);
        epee = new ItemArme('E', Color.GRAY,"epee", 15,20);
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
}
