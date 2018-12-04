package world;

import java.awt.*;
import java.util.ArrayList;
import Object.*;
import color.*;

public class World {
	private Tile[][] tiles;
	private Item[][] items;
	private ArrayList<Point> itemPointList;
	private int width;
	private Point pt;
	public int width() { return width; }
	
	private int height;
	public int height() { return height; }
	
	public World(Tile[][] tiles, Point pt, ArrayList<Point> itemPointList){
		this.tiles = tiles;
		this.width = tiles.length;
		this.height = tiles[0].length;
		this.pt = pt;
		this.itemPointList = itemPointList;
		this.items = new Item[160][95];	// --> pourquoi x : 160  et y : 95, mystere total.. items[width][height] ne fonctionne pas --> OutOfBoundsException
	}
	
	public Tile tile(int x, int y){
		if (x < 0 || x >= width || y < 0 || y >= height)
			return Tile.BOUNDS;
		else
			return tiles[x][y];
	}

	public char glyph(int x, int y){
		if (items[x][y] != null)
			return items[x][y].glyph();

		return tile(x, y).glyph();
	}

	public Color color(int x, int y){
		if (items[x][y] != null)
			return items[x][y].color();

		return tile(x, y).color();
	}

	public void addItemAtLocation(Item item) {
		for (int i = 0; i < itemPointList.size(); i++){
			if (itemPointList.get(i) != null && (items[(int) itemPointList.get(i).getX()][(int) itemPointList.get(i).getY()]) == null){
				items[(int) itemPointList.get(i).getX()][(int) itemPointList.get(i).getY()] = item;
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
}