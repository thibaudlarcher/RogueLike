package creature.PJ;

import Object.Items.Item;
import creature.Creature;

public abstract class PJ extends Creature {

    protected String name;

    public String getName() {
        return name;
    }

    public abstract void pickupItem(Item item);

    public abstract void dropItem(Item item);

}
