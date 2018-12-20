package object.items;

import java.awt.*;

/**
 * Classe pour gérer les items arme.
 */
public class ItemArme extends Item {

    /**
     * Attribut pour les degats de l'arme.
     */
    private int Dammage;

    /**
     * Le constructeur de la classe.
     * @param glyph le glyphe de l'item.
     * @param color la couleur de l'item.
     * @param name le nom de l'item.
     * @param Dammage les dégats de l'item.
     * @param valeur la valeur marchande de l'item.
     */
    public ItemArme(char glyph, Color color, String name, int Dammage, int valeur) {
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.Dammage = Dammage;
        this.type = "arme";
        this.valeur = valeur;
        this.equipe = false;
    }

    public int getDammage() {
        return this.Dammage;
    }

    public int getDefense() {
        return 0;
    }

    public int getEffet() {
        return 0;
    }

    @Override
    public String toString() {
        return 1 + " " + glyph + " " + color.getBlue() + " " + color.getRed() + " " + color.getGreen() + " " + name + " " + Dammage + " " + valeur + " " + equipe;
    }
}
