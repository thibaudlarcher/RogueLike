package object.Items;

import java.awt.*;

public class ItemEquipementBotte extends Item {

    private int defense;

    public ItemEquipementBotte(char glyph, Color color, String name, int defense, int valeur){
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

    public int getDefense(){ return this.defense; }

    public int getEffet() {
        return 0;
    }

    @Override
    public String toString(){
        return 3 + " " + glyph + " " + color.getBlue() + " " + color.getRed() +" " + color.getGreen()+ " " + name + " " + defense+ " " + valeur + " " + equipe;
    }
}
