package creature.monstre;

import object.items.Item;
import static asciiPanel.AsciiPanel.red;

/**
 *  Classe d'un certain type de monstre que l'on retrouve dans le Donjon
 *  Elle est Extends a la Classe monstre
 *
 * @see Monstre
 * @see creature.Creature
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */
public class Kobold extends Monstre {
    /**
     * On va pré-créer une instance d'un monstre particulier
     * Il va prendre les caractéristiues que l'on pré-fixe
     */
    public Kobold() {
        this.name = "Kobold";
        this.color = red;
        this.pointDeVieMax = 20;
        this.vitesse = 4;
        this.tour = 0;
        this.pointDeVie = 20;
        this.attaque = 6;
        this.glyph = 'K';
    }

    /**
     * On réécrit une instance de monstre qui lui même est un extends a la classe créature
     * Cependant les Monstres autre que le player ne peuvent pas drop d'item (pour l'instant)
     * @param item représente un Item dans l'inventaire
     */
    @Override
    public void dropItem(Item item) {
    }

    /**
     * On réécrit une instance de monstre qui lui même est un extends a la classe créature
     * Cependant les Monstres autre que le player ne peuvent pas rammasser d'items (pour l'instant)
     * @param item représente un Item sur le sol
     */
    @Override
    public void pickupItem(Item item) {
    }
}