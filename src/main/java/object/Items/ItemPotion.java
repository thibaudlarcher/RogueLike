package object.Items;

import java.awt.*;

/**
 * Classe pour gérer les items de type potion.
 */
public class ItemPotion extends Item {

    /**
     * Attribut pour l'effet que procure l'item.
     */
    private int effet;

    /**
     * Constructeur de la classe.
     * @param glyph le glyphe de l'item.
     * @param color la couleur de l'item.
     * @param name le nom de l'item.
     * @param effet l'effet que procure l'item.
     * @param valeur la valeur marchande de l'item.
     */
    public ItemPotion(char glyph, Color color, String name, int effet, int valeur){
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.type = "potion";
        this.effet = effet;
        this.valeur = valeur;
        this.equipe = false;
    }

    /**
     * @return l'effet que procure l'item.
     */
    public int getEffet(){
        return this.effet;
    }

    public int getDammage() {
        return 0;
    }

    public int getDefense() {
        return 0;
    }
    @Override
    public String toString(){
        return 4 + " " + glyph + " " + color.getBlue() + " " + color.getRed() +" " + color.getGreen()+ " " + name + " " + effet+ " " + valeur + " " + equipe;
    }
}
