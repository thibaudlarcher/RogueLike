package screens.Combat;

import creature.GroupCreature;
import screens.LoseScreen;
import screens.Screen;

import java.util.ArrayList;

public class TestMort {
    private TestMort() {}

    public static void testMort(GroupCreature creature, int i){
        if(creature.getGroupCreature().get(i).getPointDeVie() <= 0) {
            creature.getGroupCreature().remove(i);
        }
    }

    public static boolean testMortGroupe(ArrayList<GroupCreature> groupCreature,int numero){
        if(groupCreature.get(numero).getGroupCreature().size() == 0) {
            groupCreature.remove(numero);
            return true;
        }
        return false;
    }

    public static boolean mortPersonnage(GroupCreature player){
        //System.out.println(player.getGroupCreature().get(0).getName());
        if (player.getGroupCreature().get(0).getPointDeVie() <= 0){
            //player.getGroupCreature().remove(0);
            //System.out.println("mort perso");
            return true;
        }
        return false;
    }
}
