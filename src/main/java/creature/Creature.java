package creature;
import java.awt.Color;
import object.*;
import object.Items.Item;
//import world.World;

public abstract class Creature {
    //private World world;
    protected Inventory inventory;

    public Inventory inventory() {
        return inventory;
    }

    public int x;
    public int y;

	protected char glyph;
    public char getGlyph() {
        return glyph;
    }

    protected Color color;
    public Color getColor() {
        return color;
    }

    protected int pointDeVieMax;
    public int getPointDeVieMax() {
        return pointDeVieMax;
    }


    protected int pointDeVie;
    public int getPointDeVie() {
        return pointDeVie;
    }
    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    protected int attaque;
    public int getAttaque() {
        return attaque;
    }

    public abstract void pickupItem(Item item);

    public abstract void dropItem(Item item);
}

