package creature.PJ;
import object.Items.*;
import object.*;
import static asciiPanel.AsciiPanel.brightGreen;

/**
 *  Classe d'une classe de joueur
 *  Elle est Extends a la Classe PJ
 *
 * @see PJ
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */

public class Guerrier extends PJ{

    /**
     * Constructeur de la classe Guerrier, ici on va donner des arguments
     * @param name Nom du guerrier
     * @param pointDeVie Nombre de point vie du personnage joueur
     * @param attaque puissance d'attaque de la classe
     */
    public Guerrier(String name, int pointDeVie, int attaque) {
       this.color = brightGreen;
        pointDeVieMax = pointDeVie;
        this.pointDeVie = pointDeVie;
        this.name = name;
        vitesse = 6;
        tour = 0;
        this.attaque = attaque;
        this.magicattaque = 0;
        glyph = 'G';
        this.inventory = new Inventory(10);
        this.defense = 0;
    }

    /**
     * Constructeur de la classe Guerrier par défaut
     */
    public Guerrier() {
        this.color = brightGreen;
        vitesse = 6;
        tour = 0;
        glyph = 'G';
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
