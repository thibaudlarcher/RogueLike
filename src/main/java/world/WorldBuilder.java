package world;
import Tiles.*;
import gameroots.mapgen.bsp.BspMapCreator;
import java.awt.*;
import java.util.ArrayList;

/**
 * Classe de la construction du monde
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class WorldBuilder {

    /**
     * Stock la largeur.
     */
	private int width;

    /**
     * Stock la hauteur.
     */
	private int height;

    /**
     * Stock les tiles.
     */
	private Tile[][] tiles;

    /**
     * Stock les chars du BSP Creator.
     */
	private char[][] ch;

    /**
     * Point du spawn du player.
     */
	private Point ptSpawn;

    /**
     * Point du spawn du villages.
     */
	private Point ptSpawnVillage;

    /**
     * Liste des points de chaque items.
     */
	private ArrayList<Point> itemPointList;

    /**
     * Liste des points de chaque monstres.
     */
	private ArrayList<Point> ptmonstre;

	/**
     * Savoir si on est dans le village.
	 */
	private boolean inVillage;
    private ArrayList<Point> ptvillageois;

    /**
     * Constructeur du World Builder.
     * @param width Largeur
     * @param height Hauteur
     */
	public WorldBuilder(int width, int height) {
		this.width = width;
		this.height = height;
		this.tiles = new Tile[width][height];
		this.itemPointList = new ArrayList<>();
		this.ptmonstre = new ArrayList<Point>();
		this.ptvillageois = new ArrayList<Point>();
	}

    /**
     * Permet de construire le monde.
     * @return World
     */
	public World build() {
	    inVillage = false;
        BspMapCreator bspMapCreator = new BspMapCreator();
        bspMapCreator.setMinRoomSize(5);
        bspMapCreator.setMaxIterations(6);
        bspMapCreator.setMapDimension(this.width, this.height);
        ch = bspMapCreator.createMap();
        return new World(WorldGenerating(ch), ptSpawn, ptSpawn, itemPointList, ptmonstre);
	}

    /**
     * Permet de construire le village.
     * @return Wolrd village
     */
    public World buildVillage() {
	    inVillage = true;
        BspMapCreator bspMapCreator = new BspMapCreator();
        bspMapCreator.setMinRoomSize(5);
        bspMapCreator.setMaxIterations(0);
        bspMapCreator.setMapDimension(this.width, this.height);
        ch = bspMapCreator.createMapVillage();
        return new World(VillageGenerating(ch), ptSpawnVillage, ptvillageois);
    }

    /**
     * Permet de générer le monde du jeu grace au char[][] du BSP creator.
     * @param ch Char[][]
     * @return Tile[][]
     */
	public Tile[][] WorldGenerating(char[][] ch){
        for (int i = 0; i < this.width; i++){
            for (int j = 0; j < this.height; j++){
                if (ch[j][i]=='.' || ch[j][i]==',' || ch[j][i]=='|' || ch[j][i]=='-'){
                    tiles[i][j] = Tile.FLOORUNKNOW;
                } else if (ch[j][i]=='#'){
                    tiles[i][j] = Tile.WALLUNKNOW;
                } else if (ch[j][i]=='~'){
                    tiles[i][j] = Tile.BOUNDS;
                } else if (ch[j][i]=='o'){
                    tiles[i][j] = Tile.ITEMSUNKNOW;
                    itemPointList.add(new Point(i,j));
                } else if (ch[j][i]=='@'){
                    tiles[i][j] = Tile.FLOORUNKNOW;
                    ptSpawn = new Point(i,j);
                } else if (ch[j][i]==(char)144){
                    tiles[i][j] = Tile.FLOORUNKNOW;
                    ptmonstre.add(new Point(j,i));
                    //System.out.println("TestWorldBuilder");
                  }
            }
        }
        tiles = InsertVillagePortal();
        return tiles = InsertExit();
    }

    /**
     * Permet de générer le villages grace au Char[][] du BSP creator.
     * @param ch Char[][]
     * @return Tile[][]
     */
    public Tile[][] VillageGenerating(char[][] ch){
        for (int i = 0; i < this.width; i++){
            for (int j = 0; j < this.height; j++){
                if (ch[j][i]=='.' || ch[j][i]==',' || ch[j][i]=='|' || ch[j][i]=='-'){
                    tiles[i][j] = Tile.FLOOR;
                } else if (ch[j][i]=='#'){
                    tiles[i][j] = Tile.WALL;
                } else if (ch[j][i]=='~'){
                    tiles[i][j] = Tile.BOUNDS;
                } else if (ch[j][i]=='@'){
                    tiles[i][j] = Tile.FLOOR;
                    ptSpawnVillage = new Point(i,j);
                } else if (ch[j][i]=='w'){
                    tiles[i][j] = Tile.VILLAGEOISVISITED;
                    ptvillageois.add(new Point(i,j));
                }
            }
        }
        return tiles = InsertExit();
    }

    /**
     * Permet de générer la sortie dans la Map.
     * @return Tile[][]
     */
    public Tile [][] InsertExit(){
        int x;
        int y;

        do {
            x = (int)(Math.random() * width);
            y = (int)(Math.random() * height);
        }
        while (!(tiles[x][y].isGround() && tiles[x+1][y].isGround() && tiles[x-1][y].isGround() && tiles[x][y+1].isGround() &&
                tiles[x][y-1].isGround()));

        if (inVillage == true){
            tiles[x][y] = Tile.EXIT;
        } else tiles[x][y] = Tile.EXITUNKNOW;
	    return tiles;
    }

    /**
     * Permet de générer le protail vers le village.
     * @return Tile[][]
     */
    public Tile [][] InsertVillagePortal(){
        int x;
        int y;

        do {
            x = (int)(Math.random() * width);
            y = (int)(Math.random() * height);
        }
        while (!(tiles[x][y].isGround() && tiles[x+1][y].isGround() && tiles[x-1][y].isGround() && tiles[x][y+1].isGround() &&
                tiles[x][y-1].isGround()));

        tiles[x][y] = Tile.VILLAGEPORTALUNKNOW;
        return tiles;
    }

    /**
     * Getter du point du spawn.
     * @return Point du spawn
     */
    public Point getPtSpawn() {
        return ptSpawn;
    }

    /**
     * Getter du point du spawn sur le village.
     * @return Point du spawn du village
     */
    public Point getPtSpawnVillage() {
        return ptSpawnVillage;
    }

    /**
     * Getter du point des monstres.
     * @return Montres
     */
    public ArrayList<Point> getPtmonstre(){
	    return ptmonstre;
    }
}