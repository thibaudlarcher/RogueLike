package creature.PNJ;

import object.Inventory;

/**
 * Classe villageois extends la classe principale PNJ
 *
 * @see PNJ
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */

public class Villageois extends PNJ {
    /**
     * Constructeur de la classe villageois
     * @param name Nom du PNJ
     */
    public Villageois(String name){
        this.name = name;
        this.inventory = new Inventory(5);
    }
}
