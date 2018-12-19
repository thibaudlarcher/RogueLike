package gameroots.mapgen.bsp;

import gameroots.shared.geom.IntRect;

/**
 * Classe de la création des cellules
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */


public class CellNode {

	/**
	 * Permet de stocker un booléan.
	 */
	boolean horizontal;

	/**
	 * Permet de stocker la profondeur de la cellule.
	 */
	int depth;
	/**
	 * Position en x.
	 * Position en y.
	 * Largeur.
	 * Hauteur.
	 */
	int x, y, width, height;

	/**
	 * La cellule qui est à sa gauche.
	 */
	CellNode left;

	/**
	 * La cellule qui est à sa droite.
	 */
	CellNode right;

	/**
	 * Rectangle qui correspond a une room.
	 */
	IntRect room;

	/**
	 * Rectangle qui correspond a un couloir.
	 */
	IntRect corridor;

	/**
	 * Constructeur de la classe CellNode.
	 * @param x Position en x.
	 * @param y Position en y.
	 * @param width Largeur.
	 * @param height Hauteur.
	 */
	public CellNode(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Retourne la postion de la cellule et de sa largeur et hauteur.
	 * @return Un string
	 */
	@Override
	public String toString() {
		return "CellNode{" +
		  "x=" + x +
		  ", y=" + y +
		  ", width=" + width +
		  ", height=" + height +
		  '}';
	}
}
