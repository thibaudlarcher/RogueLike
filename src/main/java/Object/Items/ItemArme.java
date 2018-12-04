package Object.Items;
import java.awt.*;

public class ItemArme extends Item {

    protected int Dammage;

    public ItemArme(char glyph, Color color, String name, int Dammage) {
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.Dammage = Dammage;
    }

    public int getDammage(){
        return this.Dammage;
    }

}
