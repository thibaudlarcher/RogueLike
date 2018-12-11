package object.Items;

import java.awt.*;

public class ItemPotion extends Item {

    private int effet;

    public ItemPotion(char glyph, Color color, String name, int effet, int valeur){
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.type = "potion";
        this.effet = effet;
        this.valeur = valeur;
        this.equipe = false;
    }

    public int getEffet(){
        return this.effet;
    }

    public int getDammage() {
        return 0;
    }

    public int getDefense() {
        return 0;
    }
}
