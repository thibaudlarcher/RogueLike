package creature;
import java.awt.Color;
import java.util.ArrayList;

import creature.PJ.PJ;
import world.World;

public class GroupCreature {
    private World world;

    public int x;
    public int getX() {
        return x;
    }

    public int y;
    public int getY() {
        return y;
    }


    private ArrayList<Creature> groupCreature;
    public ArrayList<Creature> getGroupCreature() {
        return groupCreature;
    }

    private char glyph;
    private Color color;
    public Color getColor() { return color; }
    public char glyph() { return glyph; }
    private CreatureAi ai;
    public void setCreatureAi(CreatureAi ai) { this.ai = ai; }

    public GroupCreature(World world, char glyph, Color color, PJ Crea1){
        groupCreature = new ArrayList<Creature>();
        groupCreature.add(Crea1);
        this.world = world;
        this.glyph = glyph;
        this.color = color;
    }

    /*public GroupCreature(World world, char glyph, Color color) {
        groupCreature = new ArrayList<Creature>();
        this.world = world;
        this.glyph = glyph;
        this.color = color;
    }*/

    public GroupCreature(World world, char glyph, Color color,int x, int y){
        groupCreature = new ArrayList<Creature>();
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    /* public GroupCreature(World world, char glyph, Color color, Creature Crea1,int x, int y){
        groupCreature = new ArrayList<Creature>();
        groupCreature.add(Crea1);
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.x = x;
        this.y = y;
    }*/

    public boolean isNextTo(int x, int y){
        if(this.x == x && this.y == y){
            return true;
        } else if(this.x == x+1 && this.y == y){
            return true;
        } else if(this.x == x-1 && this.y == y){
            return true;
        } else if(this.x == x && this.y == y+1){
            return true;
        } else if(this.x == x && this.y == y-1){
            return true;
        }
        return false;
    }

    public void moveBy(int mx, int my){
        ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
        //System.out.println("x :"+ x+ "y : " + y);
    }

    public boolean isDead (){
        boolean mort = true;
        for(int i = 0;i < groupCreature.size(); i++){
            mort = mort && groupCreature.get(i).isDead();
        }
        return mort;
    }

    public void setWorld(World world) {
        this.world = world;
    }

}
