package object.Items;

import java.awt.*;

public class ItemEquipementArmure extends Item {

    private int defense;

    public ItemEquipementArmure(char glyph, Color color, String name, int defense){
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.defense = defense;
        this.type = "armure";
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
        return 2 + " " + glyph + " " + color.getBlue() + " " + color.getRed() +" " + color.getGreen()+ " " + name + " " + defense  +"  " + type;
    }
}
