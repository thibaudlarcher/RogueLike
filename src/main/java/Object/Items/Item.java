package Object.Items;
import java.awt.*;

public abstract class Item {
    // 1 item par room

    protected char glyph;
    public char getGlyph() { return glyph; }

    protected Color color;
    public Color getColor() { return color; }

    protected String name;
    public String getName() { return name; }

    public abstract int getDammage();
}
