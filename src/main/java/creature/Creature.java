package creature;
import java.awt.Color;
//import world.World;

public abstract class Creature {

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
