package creature.pnj;

import creature.Creature;
import object.Inventory;
import object.items.Item;

public abstract class PNJ extends Creature {

    protected String name;
    public String getName() {
        return name;
    }

    protected Inventory inventory;
    public Inventory inventory() {
        return inventory;
    }

    @Override
    public void pickupItem(Item item) {}

    @Override
    public void dropItem(Item item) {}
}
