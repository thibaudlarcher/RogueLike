package object.Items;
import java.awt.*;

public class ItemArme extends Item {

    private int Dammage;

    public ItemArme(char glyph, Color color, String name, int Dammage, int valeur) {
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.Dammage = Dammage;
        this.type = "arme";
        this.valeur = valeur;
    }

    public int getDammage(){
        return this.Dammage;
    }

    public int getDefense() {
        return 0;
    }

    public int getEffet() {
        return 0;
    }

}
