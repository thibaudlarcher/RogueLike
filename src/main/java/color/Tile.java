package color;

import java.awt.Color;
import asciiPanel.AsciiPanel;

public enum Tile {
	FLOOR((char)250, AsciiPanel.black),
	WALL((char)177, AsciiPanel.brightWhite),
	EXIT((char)79, AsciiPanel.brightRed),
	PERSO((char)64, AsciiPanel.blue),
	TEST((char)75, AsciiPanel.brightCyan),
	BOUNDS('x', AsciiPanel.brightBlack),
	ITEMS((char)244, AsciiPanel.yellow),
	MONSTER((char)64, AsciiPanel.brightYellow);

	
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
