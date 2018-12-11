package object.Items;

import java.awt.*;

public class ItemEquipementCasque extends Item {
    private int defense;

    public ItemEquipementCasque(char glyph, Color color, String name, int defense, int valeur){
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.defense = defense;
        this.type = "casque";
        this.valeur = valeur;
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
}
