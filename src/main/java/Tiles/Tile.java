package Tiles;

import java.awt.Color;
import asciiPanel.AsciiPanel;

/**
 * Classe des tiles
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public enum Tile {
	FLOORUNKNOW((char)250, AsciiPanel.black),
	FLOORALREADYVISITED((char)250, AsciiPanel.brightBlack),
	FLOOR((char)250, AsciiPanel.black),
	WALLUNKNOW((char)177,AsciiPanel.black),
	WALLALREADYVISITED((char)177,AsciiPanel.brightBlack),
	WALL((char)177, AsciiPanel.brightWhite),
	EXITUNKNOW((char)79, AsciiPanel.black),
	EXITALREADYVISITED((char)79, AsciiPanel.brightBlack),
	EXIT((char)79, AsciiPanel.brightRed),
	VILLAGEPORTALUNKNOW((char) 86, AsciiPanel.black),
	VILLAGEPORTALALREADYVISITED((char) 86, AsciiPanel.brightBlack),
	VILLAGEPORTAL((char) 86, AsciiPanel.brightBlue),
	PERSO((char)64, AsciiPanel.blue),
	TEST((char)75, AsciiPanel.brightCyan),
	BOUNDS('x', AsciiPanel.black),
	ITEMSUNKNOW('o', AsciiPanel.black),
	ITEMALREADYVISITED('o', AsciiPanel.black),
	ITEMS('o', AsciiPanel.black),
	MONSTER((char)64, AsciiPanel.brightYellow),
	VILLAGEOIS('v', AsciiPanel.brightMagenta),
	VILLAGEOISVISITED('v', AsciiPanel.brightBlack);

	/**
	 * Permet de stocker le caractère de chaque glyph
	 */
	private char glyph;

    /**
     * Permet de récupérer le glyph
     * @return glyph
     */
	public char glyph() {
		return glyph;
	}

	/**
	 * Stock la couleur du glyph
	 */
	private Color color;

    /**
     * permet de retourner la couleur
     * @return couleur
     */
	public Color color() {
		return color;
	}

	/**
	 * Constructeur de la classe tiles
	 * @param glyph Caractère
	 * @param color Couleur
	 */
	Tile(char glyph, Color color){
		this.glyph = glyph;
		this.color = color;
	}

	/**
	 * Permet de tester si c'est un floor
	 * @return boolean
	 */
	public boolean isGround() {
		return this != WALL && this != BOUNDS && this != WALLALREADYVISITED && this != WALLUNKNOW;
	}

}
