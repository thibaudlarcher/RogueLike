package creature.PJ;

import object.Inventory;
import object.Items.Item;
import creature.Creature;

public abstract class PJ extends Creature {

    protected String name;
    protected Inventory inventory;

    public Inventory inventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }


    public abstract void pickupItem(Item item);

    public abstract void dropItem(Item item);

    public abstract void updateAttaque(int attaque);
}
