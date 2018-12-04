package creature;
import java.awt.Color;
//import world.World;

public abstract class Creature {
	//private World world;

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
	public abstract int getPointDeVieMax();

    protected int pointDeVie;
    public abstract int getPointDeVie();

    protected int attaque;
    public abstract int getAttaque();

}
