package object.Items;

import java.awt.*;

public class ItemPierreDeTeleportation extends Item {

    public ItemPierreDeTeleportation(char glyph, Color color, String name){
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.valeur = 0;
        this.equipe = false;
        this.type = "pierreTP";
    }

    @Override
    public int getDammage() {
        return 0;
    }

    @Override
    public int getDefense() {
        return 0;
    }

    @Override
    public int getEffet() {
        return 0;
    }
}
