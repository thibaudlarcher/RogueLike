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

    protected String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

	protected char glyph;
    public char getGlyph() {
        return glyph;
    }
    public void setGlyph(char glyph) {
         this.glyph = glyph;
    }

    protected Color color;
    public Color getColor() {
        return color;
    }

    protected int pointDeVieMax;
    public int getPointDeVieMax() {
        return pointDeVieMax;
    }
    public void setPointDeVieMax(int pointDeVieMax) {
        this.pointDeVieMax = pointDeVieMax;
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
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    protected int vitesse;
    public int getVitesse() {
        return vitesse;
    }

    protected int tour;
    public int getTour() {
        return tour;
    }
    public void setTour(int tour) {
        this.tour = tour;
    }
    public void updateTour() {
        this.setTour(tour+vitesse);
    }

    public void dealDamageTo(Creature Crea){
        Crea.setPointDeVie(Crea.getPointDeVie() - this.getAttaque());
        this.setTour(0);
    }

    public boolean isDead() {
        if(this.getPointDeVie() < 0) return true;
        return false;
    }

    public abstract void pickupItem(Item item);

    public abstract void dropItem(Item item);
}

