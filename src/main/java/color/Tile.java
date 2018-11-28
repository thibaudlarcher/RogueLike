package color;

import java.awt.Color;
import asciiPanel.AsciiPanel;

public enum Tile {
	FLOOR((char)250, AsciiPanel.black),
	WALL((char)177, AsciiPanel.brightWhite),
	EXIT((char)79, AsciiPanel.brightRed),
	BOUNDS('x', AsciiPanel.brightBlack);

	
	private char glyph;
	public char glyph() { return glyph; }
	
	private Color color;
	public Color color() { return color; }
	
	Tile(char glyph, Color color){
		this.glyph = glyph;
		this.color = color;
	}

	public boolean isGround() {
		return this != WALL && this != BOUNDS;
	}

}
