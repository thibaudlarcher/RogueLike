package object.Items;

import java.awt.*;

public class ItemEquipementPantalon extends Item {
    private int defense;

    public ItemEquipementPantalon(char glyph, Color color, String name, int defense){
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.defense = defense;
        this.type = "pantalon";
    }

    public int getDammage() {
        return 0;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getEffet() {
        return 0;
    }

    @Override
    public String toString(){
        return 6 + " " + glyph + " " + color.getBlue() + " " + color.getRed() +" " + color.getGreen()+ " " + name + " " + defense;
    }
}
