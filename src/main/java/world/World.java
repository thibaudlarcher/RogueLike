package world;

import java.awt.*;
import java.util.ArrayList;
import object.Items.Item;
import color.*;

public class World {
	private Tile[][] tiles;
	private Item[][] items;
	private ArrayList<Point> itemPointList;
	private int width;
	private Point pt;
	public int width() { return width; }
	private ArrayList<Point> listMonster;
	private int height;
	public int height() { return height; }
	
	public World(Tile[][] tiles, Point pt, ArrayList<Point> itemPointList,ArrayList<Point> listMonster){
		this.tiles = tiles;
		this.width = tiles.length;
		this.height = tiles[0].length;
		this.pt = pt;
		this.itemPointList = itemPointList;
		this.items = new Item[width+40][height];	// --> on prend le x max entre screenWidth et width et y max entre screenHeight et height
		this.listMonster = listMonster;
	}
	
	public Tile tile(int x, int y){
		if (x < 0 || x >= width || y < 0 || y >= height)
			return Tile.BOUNDS;
		else
			return tiles[x][y];
	}

	public char glyph(int x, int y){
		if (items[x][y] != null)
			return items[x][y].getGlyph();

		return tile(x, y).glyph();
	}

	public Color color(int x, int y){
		if (items[x][y] != null)
			return items[x][y].getColor();

		return tile(x, y).color();
	}

	public void addItemAtLocation(Item item) {
		int randx = (int)(Math.random() * itemPointList.size());

		for (int i = randx; i < itemPointList.size(); i++){
			if (itemPointList.get(i) != null && (items[(int) itemPointList.get(i).getX()][(int) itemPointList.get(i).getY()]) == null){
				items[(int) itemPointList.get(i).getX()][(int) itemPointList.get(i).getY()] = item;
				break;
			}
		}
	}

	public Point getPt() {
		return pt;
	}

	public void setPt(Point pt) {
		this.pt = pt;
	}

	public Item item(int x, int y){
		return items[x][y];
	}

	public void itemVide(int x, int y){
		items[x][y] = null;
		tiles[x][y] = Tile.FLOOR;
	}

	public ArrayList<Point> getListMonster() {
		return listMonster;
	}
}