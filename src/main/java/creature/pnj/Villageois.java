package creature.pnj;

import object.Inventory;

/**
 * Classe villageois extends la classe principale pnj
 *
 * @see PNJ
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */

public class Villageois extends PNJ {
    /**
     * Constructeur de la classe villageois
     * @param name Nom du pnj
     */
    public Villageois(String name){
        this.name = name;
        this.inventory = new Inventory(5);
    }
}