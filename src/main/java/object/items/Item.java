package object.items;
import java.awt.*;

/**
 * Classe abstraite pour gérer les items.
 */
public abstract class Item {
    // 1 item par room

    /**
     * Le glyphe de l'item.
     */
    protected char glyph;

    /**
     * @return le glyphe de l'item.
     */
    public char getGlyph() {
        return glyph;
    }

    /**
     * La couleur de l'item.
     */
    protected Color color;

    /**
     * @return la couleur de l'item.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Méthode pour définir la couleur de l'item.
     * @param color la nouvelle couleur de l'item.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Le nom de l'item.
     */
    protected String name;

    /**
     * @return le nom de l'item.
     */
    public String getName() {
        return name;
    }

    /**
     * Le type de l'item.
     */
    protected String type;

    /**
     * @return le type de l'item.
     */
    public String getType() {
        return type;
    }

    /**
     * La valeur marchande de l'item.
     */
    protected int valeur;

    /**
     * @return la valeur marchande de l'item.
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * L'attribut pour savoir si l'item est équipé ou non.
     */
    protected boolean equipe;

    /**
     * @return vrai ou faux selon si l'item est équipé ou non.
     */
    public boolean isEquipe() {
        return equipe;
    }

    /**
     * Méthode pour définir si l'item est équipé ou non.
     * @param e vrai ou faux, si l'item est équipé ou non.
     */
    public void setEquipe(boolean e) {
        this.equipe = e;
    }

    /**
     * @return les dégats de l'item, si c'est une arme.
     */
    public abstract int getDammage();

    /**
     * @return la defense que procure l'item, si c'est un équipement défensif.
     */
    public abstract int getDefense();

    /**
     * @return l'effet que procure l'item, si c'est une potion.
     */
    public abstract int getEffet();

    /**
     * @return l'item sous format String.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
