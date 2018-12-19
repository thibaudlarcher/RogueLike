package gameroots.shared.geom;

/**
 * Classe de la création des points
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class IntPoint {
	/**
	 * Permet de stocker la position du point en x.
	 * Permet de stocker la position du point en y.
	 */
	public int x, y;

	/**
	 * Constructeur par défaut du point.
	 */
	public IntPoint() {
	}

	/**
	 * Constructeur alternatif du point.
	 * @param x Position den x
	 * @param y Position en y
	 */
	public IntPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Permet de tester un égaliter entre deux points.
	 * @param o L'objet
	 * @return vrais ou faux
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		IntPoint intPoint = (IntPoint)o;

		if (x != intPoint.x)
			return false;
		return y == intPoint.y;
	}

	/**
	 * Permet de faire une méthode de hash
	 * @return valeur de la hash
	 */
	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}
}
