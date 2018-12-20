package creature.monstre;

import creature.Creature;
import creature.GroupCreature;

/**
 *  Classe d'un monstre, Elle permet de donner une action d'attaquer au différent monstre
 *  Elle est Extends a la Classe Creature
 *
 * @see creature.Creature
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */

public abstract class Monstre extends Creature {

    /**
     * Fonction qui permet de faire un dommage sur un player en fonction de son attaque définie sur la classe du type de monstre
     * @param player réprésente un joueur
     */
    public void takeAction (GroupCreature player){
        this.dealDamageTo(player.getGroupCreature().get((int)(Math.random()
                * (player.getGroupCreature().size()))));
    }

}