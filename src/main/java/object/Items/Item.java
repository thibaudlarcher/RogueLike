package object.Items;
import java.awt.*;

public abstract class Item {
    // 1 item par room

    protected char glyph;
    public char getGlyph() { return glyph; }

    protected Color color;
    public Color getColor() { return color; }

    public void setColor(Color color) {
        this.color = color;
    }

    protected String name;
    public String getName() { return name; }

    protected String type;
    public String getType(){ return type; }

    public abstract int getDammage();
    public abstract int getDefense();
    public abstract int getEffet();
}
