package world;

import java.awt.*;
import java.util.ArrayList;
import object.items.Item;
import Tiles.*;

/**
 * Classe du World
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class World {

	/**
	 * Stock la map des tiles
	 */
	public Tile[][] tiles;

	/**
	 * Stock les items
	 */
	public Item[][] items;

	/**
	 * Stock la position des items
	 */
	private ArrayList<Point> itemPointList;

	/**
	 * Stock la largeur
	 */
	private int width;

	/**
	 * Stock la hauteur
	 */
	private int height;

	/**
	 * Stock le poitn du player
	 */
	private Point pt;

	/**
	 * Stock le point de la téléportation du village
	 */
	private Point ptVillage;

	/**
	 * Permet de récupérer la largeur
	 * @return valeur de la largeur
	 */
	public int width() { return width; }

	/**
	 * Stock la liste des monstres dans la Map
	 */
	private ArrayList<Point> listMonster;

	/**
	 * Stock la liste des villageois du village
	 */
	private ArrayList<Point> listVillageois;

    /**
     * Permet de récupérer la hauteur
     * @return valeur de la hauteur
     */
	public int height() { return height; }

	/**
	 * Stock le point du spawn du player
	 */
	private Point ptSpawn;

	/**
	 * Permet de récupérer le point du spawn du player
	 * @return valeur du point
	 */
	public Point getPtSpawn(){ return ptSpawn; }

    /**
     * Constructeur pour la construction du world
     * @param tiles Les tiles
     * @param pt Point player
     * @param ptSpawn Point du spawn
     * @param itemPointList Points des items
     * @param listMonster Liste des monstres
     */
	public World(Tile[][] tiles, Point pt, Point ptSpawn, ArrayList<Point> itemPointList, ArrayList<Point> listMonster){
		this.tiles = tiles;
		this.width = tiles.length;
		this.height = tiles[0].length;
		this.pt = pt;
		this.itemPointList = itemPointList;
		this.items = new Item[width+40][height];	// --> on prend le x max entre screenWidth et width et y max entre screenHeight et height
		this.listMonster = listMonster;
		this.ptSpawn = ptSpawn;
	}

    /**
     * Constructeur pour la construction du villages
     * @param tiles Liste des tiles
     * @param pt Point du player
     * @param listVillageois Point des monstres (villageois)
     */
	public World(Tile[][] tiles, Point pt, ArrayList<Point> listVillageois){
		this.tiles = tiles;
		this.width = tiles.length;
		this.height = tiles[0].length;
		this.ptVillage = pt;
		this.items = new Item[width+40][height];
		this.listVillageois = listVillageois;
	}

	/**
	 * Constructeur pour la lecture de la sauvegarde
	 * @param tiles liste des tiles
	 * @param pt Point du player
	 * @param ptSpawn Point du spawn du plauer
	 * @param itemList Liste des points des items
	 * @param listMonster Listes des monstres
	 */
	public World(Tile[][] tiles, Point pt, Point ptSpawn, Item itemList[][], ArrayList<Point> listMonster){
		this.tiles = tiles;
		this.width = tiles.length;
		this.height = tiles[0].length;
		this.pt = pt;
		this.items = itemList;
		this.listMonster = listMonster;
		this.ptSpawn = ptSpawn;
	}

//	public World(Item itemList[][], ArrayList<Point> listMonster){
//		this.items = itemList;
//		this.listMonster = listMonster;
//	}

	/**
	 * retourne la tiles avec la postion en x et y
	 * @param x Position en x
	 * @param y Position en y
	 * @return la tile
	 */
	public Tile tile(int x, int y){
		if (x < 0 || x >= width || y < 0 || y >= height)
			return Tile.BOUNDS;
		else
			return tiles[x][y];
	}

	/**
	 * Récupérer la glyph de la tiles en x et y
	 * @param x Position en x
	 * @param y Position en y
	 * @return la glyph
	 */
	public char glyph(int x, int y){
		if (items[x][y] != null)
			return items[x][y].getGlyph();

		return tile(x, y).glyph();
	}

	/**
	 * Récupérer la couleur de la tiles en x et y
	 * @param x Position en x
	 * @param y Position en y
	 * @return la couleur
	 */
	public Color color(int x, int y){
		if (items[x][y] != null)
			return items[x][y].getColor();

		return tile(x, y).color();
	}

	/**
	 * Permet de modifier la tile
	 * @param tiles tile
	 */
	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	/**
	 * Permet d'ajouter un item a une position
	 * @param item item
	 */
	public void addItemAtLocation(Item item) {
		int randx = (int)(Math.random() * itemPointList.size());

		for (int i = randx; i < itemPointList.size(); i++){
			if (itemPointList.get(i) != null && (items[(int) itemPointList.get(i).getX()][(int) itemPointList.get(i).getY()]) == null){
				items[(int) itemPointList.get(i).getX()][(int) itemPointList.get(i).getY()] = item;
				break;
			}
		}
	}

	/**
	 * Getter position player x
	 * @return valeur x
	 */
	public int getPositionPersonnageX(){ return pt.x; }

	/**
	 * Getter position player y
	 * @return valeur y
	 */
	public int getPositionPersonnageY(){
		return pt.y;
	}

	/**
	 * Guetter du player en point
	 * @return point
	 */
	public Point getPt() {
		return pt;
	}

	/**
	 * permet de modifier le point du personnage
	 * @param pt point
	 */
	public void setPt(Point pt) {
		this.pt = pt;
	}

	/**
	 * Guetter position en x du villages
	 * @return valeur x
	 */
	public int getPositionPersoVillageX(){ return  ptVillage.x; }

	/**
	 * Guetter position en y du villages
	 * @return valeur y
	 */
	public int getPositionPersoVillageY(){ return ptVillage.y; }

	/**
	 * Guetter du point du village
	 * @return point
	 */
	public Point getPtVillage(){ return ptVillage; }

	/**
	 * Permet de modifier la position du point du villages
	 * @param pt Point
	 */
	public void setPtVillage(Point pt){ this.ptVillage = pt; }

	/**
	 * Guetter de l'item a une position x et y
	 * @param x Position en x
	 * @param y Position en y
	 * @return item
	 */
	public Item item(int x, int y){
		return items[x][y];
	}

	/**
	 * Permet de modifier la tile une fois l'item pickup
	 * @param x Position en x
	 * @param y Position en y
	 */
	public void itemPickVide(int x, int y){
		items[x][y] = null;
		tiles[x][y] = Tile.FLOOR;
	}

	/**
	 * Permet de modifier la tile une fois l'item déposé
	 * @param x Position en x
	 * @param y Position en y
	 */
	public void itemDropPlein(int x, int y, Item item){
		items[x][y] = item;
		tiles[x][y] = Tile.ITEMS;
	}

	/**
	 * Guetter de la liste des monstre
	 * @return liste
	 */
	public ArrayList<Point> getListMonster() {
		return listMonster;
	}

	/**
	 * Guetter des tile de la Map
	 * @return Tiles
	 */
	public Tile[][] getTiles() {
		return tiles;
	}

	/**
	 * Guetter des items
	 * @return items
	 */
	public Item[][] getItems() {
		return items;
	}

    /**
     * Guetteer de la liste des points des villageois
     * @return liste de point
     */
    public ArrayList<Point> getListVillageois(){ return  listVillageois; }
}