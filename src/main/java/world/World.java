package world;

import java.awt.*;
import Object.*;
import color.*;

public class World {
	private Tile[][] tiles;
//	private Item[][] items;
	private int width;
	private Point pt;
	public int width() { return width; }
	
	private int height;
	public int height() { return height; }
	
	public World(Tile[][] tiles, Point pt){
		this.tiles = tiles;
		this.width = tiles.length;
		this.height = tiles[0].length;
		this.pt = pt;
//		this.items = new Item[this.width][this.height];	//x : 160 y : 95
	}
	
	public Tile tile(int x, int y){
		if (x < 0 || x >= width || y < 0 || y >= height)
			return Tile.BOUNDS;
		else
			return tiles[x][y];
	}

//	public Item item(int x, int y){
//		System.out.println("xItem : " + x + " yItem : " + y);
//		return items[x][y];
//	}

	public char glyph(int x, int y){
//		if (item(x,y) != null)
//			return item(x,y).glyph();

		return tile(x, y).glyph();
	}

	public Color color(int x, int y){
//		if (item(x,y) != null)
//			return item(x,y).color();

		return tile(x, y).color();
	}

//	public void addAtEmptyLocation(Item item) {
//		int x;
//        int y;
//
//        do {
//            x = (int) (Math.random() * width);
//            y = (int) (Math.random() * height);
//        } while (!(tiles[x][y]).isGround() || items[x][y] != null);
//
//        items[x][y] = item;
//	}


	public Point getPt() {
		return pt;
	}

	public void setPt(Point pt) {
		this.pt = pt;
	}
}