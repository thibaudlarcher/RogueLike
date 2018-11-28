package world;

import java.awt.*;

import color.*;

public class World {
	private Tile[][] tiles;
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
	}
	
	public Tile tile(int x, int y){
		if (x < 0 || x >= width || y < 0 || y >= height)
			return Tile.BOUNDS;
		else
			return tiles[x][y];
	}
	
	public char glyph(int x, int y){
		return tile(x, y).glyph();
	}
	
	public Color color(int x, int y){
		return tile(x, y).color();
	}

	public Point getPt() {
		return pt;
	}

	public void setPt(Point pt) {
		this.pt = pt;
	}
}
