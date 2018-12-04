package creature;
import java.awt.Color;
import java.util.ArrayList;

import world.World;

public class GroupCreature {
    private World world;

    public int x;
    public int y;


    private ArrayList<Creature> groupCreature;
    public ArrayList<Creature> getGroupCreature() {
        return groupCreature;
    }

    private char glyph;
    public char glyph() { return glyph; }

    private Color color;
    public Color color() { return color; }

    private CreatureAi ai;
    public void setCreatureAi(CreatureAi ai) { this.ai = ai; }

    public GroupCreature(World world, char glyph, Color color, Creature Crea1){
        groupCreature = new ArrayList<Creature>();
        groupCreature.add(Crea1);
        this.world = world;
        this.glyph = glyph;
        this.color = color;
    }

    public GroupCreature(World world, char glyph, Color color, Creature Crea1,int x, int y){
        groupCreature = new ArrayList<Creature>();
        groupCreature.add(Crea1);
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public void moveBy(int mx, int my){
        ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
        //System.out.println("x :"+ x+ "y : " + y);
    }

}
