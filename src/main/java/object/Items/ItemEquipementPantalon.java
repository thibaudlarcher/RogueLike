package object.Items;

import java.awt.*;

public class ItemEquipementPantalon extends Item {
    private int defense;

    public ItemEquipementPantalon(char glyph, Color color, String name, int defense, int valeur){
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.defense = defense;
        this.type = "pantalon";
        this.valeur = valeur;
        this.equipe = false;
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
