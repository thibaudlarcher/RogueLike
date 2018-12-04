package Object;

import java.awt.*;

public abstract class Item {

    protected char glyph;
    public char glyph() { return glyph; }

    protected Color color;
    public Color color() { return color; }

    protected String name;
    public String name() { return name; }

    public abstract int getDammage();
}
