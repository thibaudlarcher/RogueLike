package creature;
import java.awt.Color;
import java.util.ArrayList;

import creature.PJ.PJ;
import world.World;

/**
 * Classe des Groupe Creature.
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */

public class GroupCreature {
    /**
     * Création d'un World
     */
    private World world;

    /**
     * Permet de stocker la position du player en x
     */
    public int x;

    /**
     * Permet de récupérer la position en x du player
     * @return valeur de player x
     */
    public int getX() {
        return x;
    }

    /**
     * Permet de stocker la position du player en y
     */
    public int y;

    /**
     * permet de récupérer la postiion en y du player
     * @return valeur de y du player
     */
    public int getY() {
        return y;
    }

    /**
     * permet de stocker les Creature.
     */
    private ArrayList<Creature> groupCreature;

    /**
     * Permet de récupérer la liste des monstres.
     * @return les Créatures
     */
    public ArrayList<Creature> getGroupCreature() {
        return groupCreature;
    }

    /**
     * Permet de stocker le caractère.
     */
    private char glyph;

    /**
     * Permet de stocker la couleur.
     */
    private Color color;

    /**
     * Permet de récupérer la couleur de la glyph.
     * @return couleur de la glyph
     */
    public Color getColor() { return color; }

    /**
     * Permet de récupérer la glyph.
     * @return le caractère de la glyph
     */
    public char glyph() { return glyph; }

    /**
     * Permet de stocker les créature IA.
     */
    private CreatureAi ai;

    /**
     * Permet de modifier les créatures AI.
     * @param ai Valeur d'un Créature AI
     */
    public void setCreatureAi(CreatureAi ai) { this.ai = ai; }

    /**
     * Constructeur de la Classe.
     * @param world Valeur du world
     * @param glyph Caractère du glyph
     * @param color Couleur de la glyph
     * @param Crea1 Player
     */
    public GroupCreature(World world, char glyph, Color color, PJ Crea1){
        groupCreature = new ArrayList<Creature>();
        groupCreature.add(Crea1);
        this.world = world;
        this.glyph = glyph;
        this.color = color;
    }

    /*public GroupCreature(World world, char glyph, Color Tiles) {
        groupCreature = new ArrayList<Creature>();
        this.world = world;
        this.glyph = glyph;
        this.Tiles = Tiles;
    }*/

    /**
     * Constructeur alternatif.
     * @param world Valeur du world
     * @param glyph Caractère du glyph
     * @param color Couleur de la glyph
     * @param x Position du player en x
     * @param y Position du player en y
     */
    public GroupCreature(World world, char glyph, Color color,int x, int y){
        groupCreature = new ArrayList<Creature>();
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    /* public GroupCreature(World world, char glyph, Color Tiles, Creature Crea1,int x, int y){
        groupCreature = new ArrayList<Creature>();
        groupCreature.add(Crea1);
        this.world = world;
        this.glyph = glyph;
        this.Tiles = Tiles;
        this.x = x;
        this.y = y;
    }*/

    /**
     * Permet de vérifier ce qu'il y a coté du player avec le player x et y.
     * @param x Position du player en x
     * @param y Position du player en y
     * @return un boolean entre vrais et faux
     */
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

    /**
     *
     * @param mx
     * @param my
     */
    public void moveBy(int mx, int my){
        ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
        //System.out.println("x :"+ x+ "y : " + y);
    }

    /**
     * Permet de savoir si la Créature est morte.
     * @return vrais ou faux
     */
    public boolean isDead (){
        boolean mort = true;
        for(int i = 0;i < groupCreature.size(); i++){
            mort = mort && groupCreature.get(i).isDead();
        }
        return mort;
    }

    /**
     * Permet de modifier les worlds.
     * @param world world
     */
    public void setWorld(World world) {
        this.world = world;
    }

}
