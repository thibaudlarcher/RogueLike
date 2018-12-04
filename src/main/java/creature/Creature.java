package creature;
import java.awt.Color;
import Object.*;
//import world.World;

public abstract class Creature {
    //private World world;
    private Inventory inventory;

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

}