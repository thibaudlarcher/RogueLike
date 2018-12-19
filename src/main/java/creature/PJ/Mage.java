package creature.PJ;
import object.Items.*;
import object.*;

import java.awt.*;

/**
 *  Classe d'une classe de joueur
 *  Elle est Extends a la Classe PJ
 *
 * @see PJ
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */

public class Mage extends PJ{
    /**
     * Constructeur de la classe Mage, ici on va donner des arguments
     * @param name  Nom du Mage
     * @param pointDeVie Point de vie du Mage
     * @param attaque Point d'attaque physique du Mage
     * @param magicattaque Point d'attaque magique du Mage
     */
    public Mage(String name, int pointDeVie, int attaque, int magicattaque) {
        this.color = new Color(171,71,188);
        pointDeVieMax = pointDeVie;
        this.pointDeVie = pointDeVie;
        this.name = name;
        vitesse = 6;
        tour = 0;
        this.attaque = attaque;
        this.magicattaque= magicattaque;
        glyph = 'M';
        this.inventory = new Inventory(10);
        this.defense = 0;
    }

    /**
     * Constructeur de la classe Guerrier par défaut
     */
    public Mage() {
        this.color = new Color(171,71,188);
        vitesse = 6;
        tour = 0;
        glyph = 'M';
        this.inventory = new Inventory(10);
        this.defense = 0;
    }

    /**
     * On va tester la classe pour ramasser les Items sur le sol
     * On ne peut pas en prendre plus que la limite de l'inventaire
     * @param item item
     */
    @Override
    public void pickupItem(Item item){
        if (!(inventory.isFull()) || item != null){
            inventory.add(item);
        }
    }

    /**
     * On va pouvoir lacher un item
     * Uniquement si on la place de la placer sur le sol
     * @param item item
     */
    @Override
    public void dropItem(Item item){
        inventory.remove(item);
    }

    /**
     * On va pouvoir augmenter ou diminuer l'attaque de la classe en fonction des items équipés
     * @param attaque point d'attaque
     */
    @Override
    public void updateAttaque(int attaque) {}
}
