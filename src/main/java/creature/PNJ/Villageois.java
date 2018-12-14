package creature.PNJ;

import object.Inventory;

public class Villageois extends PNJ {

    public Villageois(String name){
        this.name = name;
        this.inventory = new Inventory(5);
    }
}
