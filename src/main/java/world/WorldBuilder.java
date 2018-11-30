package world;
import color.*;
import gameroots.mapgen.bsp.BspMapCreator;

import java.awt.*;

public class WorldBuilder {
	private int width;
	private int height;
	private Tile[][] tiles;
	private char[][] ch;
	private Point pt;

	public WorldBuilder(int width, int height) {
		this.width = width;
		this.height = height;
		this.tiles = new Tile[width][height];
	}

	public World build() {
        BspMapCreator bspMapCreator = new BspMapCreator();
        bspMapCreator.setMinRoomSize(5);
        bspMapCreator.setMaxIterations(6);
        bspMapCreator.setMapDimension(this.width, this.height);
        ch = bspMapCreator.createMap();

		return new World(WorldGenerating(ch),pt);
	}

	public Tile[][] WorldGenerating(char[][] ch){
        for (int i = 0; i < this.width; i++){
            for (int j = 0; j < this.height; j++){
                if (ch[j][i]=='.' || ch[j][i]==',' || ch[j][i]=='|' || ch[j][i]=='-'){
                    tiles[i][j] = Tile.FLOOR;
                } else if (ch[j][i]=='#'){
                    tiles[i][j] = Tile.WALL;
                } else if (ch[j][i]=='~'){
                    tiles[i][j] = Tile.BOUNDS;
                } else if (ch[j][i]=='@'){
                    if (tiles[i-1][j] == Tile.BOUNDS && tiles[i][j-1] == Tile.BOUNDS){
                        tiles[i][j] = Tile.BOUNDS;
                    } else if (tiles[i-1][j] == Tile.BOUNDS && tiles[i][j-1] == Tile.WALL){
                        tiles[i][j] = Tile.BOUNDS;
                    } else if (tiles[i+1][j] == Tile.WALL){
                        tiles[i][j] = Tile.WALL;
                    } else if (tiles[i][j-1] == Tile.WALL){
                        tiles[i][j] = Tile.WALL;
                    } else {
                        tiles[i][j] = Tile.FLOOR;
                    }
                    pt = new Point(j,i);
                }

            }
        }

        return tiles = InsertExit();
    }

    public Tile [][] InsertExit(){
        int x;
        int y;

        do {
            x = (int)(Math.random() * width);
            y = (int)(Math.random() * height);
        }
        while (!(tiles[x][y].isGround() && tiles[x+1][y].isGround() && tiles[x-1][y].isGround() && tiles[x][y+1].isGround() &&
                tiles[x][y-1].isGround()));

            tiles[x][y] = Tile.EXIT;
	    return tiles;
    }

    public Point getPt() {
        return pt;
    }
}