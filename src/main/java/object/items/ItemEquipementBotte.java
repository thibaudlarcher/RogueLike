package object.items;

import java.awt.*;

/**
 * Classe pour gérer les items de type botte.
 */
public class ItemEquipementBotte extends Item {

    /**
     * Attribut pour la défense que procure l'item.
     */
    private int defense;

    /**
     * Constructeur de la classe.
     * @param glyph le glyphe de l'item.
     * @param color la couleur de l'item.
     * @param name le nom de l'item.
     * @param defense la defense que procure l'item.
     * @param valeur la valeure marchande de l'item.
     */
    public ItemEquipementBotte(char glyph, Color color, String name, int defense, int valeur) {
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.defense = defense;
        this.type = "botte";
        this.valeur = valeur;
        this.equipe = false;
    }

    public int getDammage() {
        return 0;
    }

    /**
     * @return la defense que procure l'item.
     */
    public int getDefense() {
        return this.defense;
    }

    public int getEffet() {
        return 0;
    }

    @Override
    public String toString() {
        return 3 + " " + glyph + " " + color.getBlue() + " " + color.getRed() + " " + color.getGreen() + " " + name + " " + defense + " " + valeur + " " + equipe;
    }
}
