package screens.Combat;

import creature.GroupCreature;

/**
 * Classe de la gestion de tour dans un combat
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class GestionTour {
    /**
     * Constructeur de la classe gestionTour
     */
    private GestionTour() {}

    /**
     * Permet de tester si c'est le tour du joueur.
     * @param player Player
     * @return valeur de i
     */
    public static int isJoueurTour(GroupCreature player) {
        for(int i = 0; i < player.getGroupCreature().size();i++){
            if(player.getGroupCreature().get(i).getTour() >= 100){
                return i;
            }
        }
        return -1;
    }
}
