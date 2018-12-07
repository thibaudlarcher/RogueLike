package object.Items;

import java.awt.*;

public class ItemPotion extends Item {

    private int effet;

    public ItemPotion(char glyph, Color color, String name, int effet){
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.type = "potion";
        this.effet = effet;
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
    @Override
    public String toString(){
        return 4 + " " + glyph + " " + color.getBlue() + " " + color.getRed() +" " + color.getGreen()+ " " + name + " " + effet  +"  " + type;
    }
}
