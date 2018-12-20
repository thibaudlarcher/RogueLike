package creature.pj;

import object.Inventory;
import object.items.Item;
import creature.Creature;

/**
 *  Classe principale du Player extends Creature
 *  Elle est Extends a la Classe PJ
 *
 * @see Creature
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */

public abstract class PJ extends Creature {
    /**
     * Nom de la créature
     */
    protected String name;

    /**
     * Inventaire
     */
    protected Inventory inventory;

    /**
     * Retourne l'inventaire
     * @return Inventaire
     */
    public Inventory inventory() {
        return inventory;
    }

    /**
     * Retourne le nom du player
     * @return Nom du player
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Rammasser l'item
     * @param item item
     */
    public abstract void pickupItem(Item item);

    /**
     * Lache l'item
     * @param item item
     */
    public abstract void dropItem(Item item);

    /**
     * Change l'attaque physique du player
     * @param attaque point d'attaque
     */
    public abstract void updateAttaque(int attaque);
}
