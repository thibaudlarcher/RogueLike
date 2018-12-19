package gameroots.shared.geom;

/**
 * Classe de la création des rectangles
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class IntRect {
	/**
	 * Position en x.
	 * Position en y.
	 * Largeur.
	 * Hauteur.
	 */
	public int x, y, width, height;

	/**
	 * Constructeur du rectangle.
	 */
	public IntRect() {
	}

	/**
	 * Constructeur alternatif du Rectangle.
	 * @param width Largeur
	 * @param height Hauteur
	 */
	public IntRect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * Constructeur alternatif du rectangle.
	 * @param x Position en x
	 * @param y Position en y
	 * @param width Largeur
	 * @param height Hauteur
	 */
	public IntRect(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Constructeur alternatif du rectangle.
	 * @param source Rectangle
	 */
	public IntRect(IntRect source) {
		this.x = source.x;
		this.y = source.y;
		this.width = source.width;
		this.height = source.height;
	}

	/**
	 * Permet de tester une égaliter entre deux rectangle
	 * @param o objet rectangle
	 * @return vrais ou faux
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		IntRect intRect = (IntRect)o;

		if (x != intRect.x)
			return false;
		if (y != intRect.y)
			return false;
		if (width != intRect.width)
			return false;
		return height == intRect.height;
	}

	/**
	 * Permet de récupérer la postion en y
	 * @return valeur de y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Permet de récupérer la postion en x.
	 * @return valeur de x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Permet de récupérer la largeur.
	 * @return valeur de la lageur
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Permet de récupérer la hauteur.
	 * @return valeur de la hateur
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Permet de faire une méthode de hash
	 * @return valeur de la hash
	 */
	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		result = 31 * result + width;
		result = 31 * result + height;
		return result;
	}

	/**
	 * Permet d'afficher les positions ainsi que la largeur de chaque retangles
	 * @return un String
	 */
	@Override
	public String toString() {
		return x + ":" + y + ":" + width + ":" + height;
	}
}
