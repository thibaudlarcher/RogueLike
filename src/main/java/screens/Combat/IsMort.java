package screens.Combat;

import creature.GroupCreature;
import screens.LoseScreen;
import screens.Screen;

import java.util.ArrayList;

/**
 * Classe de la mort des créatures
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class IsMort {
    /**
     * Constructeur de la classe isMort
     */
    private IsMort() {}

    /**
     * Permet de tester si une créature est morte
     * @param creature La créature
     * @param i la position de la créature
     */
    public static void CreatureMort(GroupCreature creature, int i){
        if(creature.getGroupCreature().get(i).getPointDeVie() <= 0) {
            creature.getGroupCreature().remove(i);
        }
    }

    /**
     * Permet de tester si tout le groupe de créature est mort
     * @param groupCreature le groupe de créature
     * @param numero chaque numéro de la créature dans le groupe
     * @return vrais ou faux
     */
    public static boolean CreatureMortGroupe(ArrayList<GroupCreature> groupCreature, int numero){
        if(groupCreature.get(numero).getGroupCreature().size() == 0) {
            groupCreature.remove(numero);
            return true;
        }
        return false;
    }

    /**
     * Permet de tester si le peronnage est mort
     * @param player player
     * @return vrais ou faux
     */
    public static boolean mortPersonnage(GroupCreature player){
        if (player.getGroupCreature().get(0).getPointDeVie() <= 0){
            return true;
        }
        return false;
    }
}
