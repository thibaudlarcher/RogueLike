package creature.pnj;

import creature.Creature;
import object.Inventory;
import object.items.Item;

/**
 *  Classe principale du pnj
 *  Elle est Extends a la Classe Creature
 *
 * @see Creature
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */

public abstract class PNJ extends Creature {
    /**
     * Nom du pnj
     */
    protected String name;

    /**
     * Permet de récupérer le nom du pnj
     * @return Nom
     */
    public String getName() {
        return name;
    }

    /**
     * Inventaire du pnj
     */
    protected Inventory inventory;

    /**
     * Permet de récupérer l'inventaire du pnj
     * @return Inventaire
     */
    public Inventory inventory() {
        return inventory;
    }

    /**
     * On va tester la classe pour ramasser les items sur le sol
     * On ne peut pas en prendre plus que la limite de l'inventaire
     * @param item item
     */
    @Override
    public void pickupItem(Item item) {}

    /**
     * On va pouvoir lacher un item
     * Uniquement si on la place de la placer sur le sol
     * @param item item
     */
    @Override
    public void dropItem(Item item) {}
}
