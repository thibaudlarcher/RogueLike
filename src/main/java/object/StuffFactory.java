package object;

import object.items.*;
import world.*;
import java.awt.*;

/**
 * Classe pour gérer la création des items.
 */
public class StuffFactory {

	/**
	 * Le monde dans lequel les items sont créés.
	 */
	private World world;

	/**
	 * Le constructeur de la classe.
	 * @param world le monde dans lequel les items sont créés.
	 */
	public StuffFactory(World world) {
		this.world = world;
	}

	/**
	 * Méthode pour créer une épée.
	 * @return l'item épée créé.
	 */
	public Item newSword() {
		Item sword = new ItemArme((char) 197,Color.black, "epee",8,21);
		world.addItemAtLocation(sword);
		return sword;
	}

	/**
	 * Méthode pour créer un baton.
	 * @return l'item baton créé.
	 */
	public Item newStick() {
		Item stick = new ItemArme((char) 179,Color.black,"baton",3,6);
		world.addItemAtLocation(stick);
		return stick;
	}

	/**
	 * Méthode pour créer une potion.
	 * @return l'item potion créé.
	 */
	public Item newPotion() {
		Item potion = new ItemPotion((char) 225,Color.black,"potion",10,14);
		world.addItemAtLocation(potion);
		return potion;
	}

	/**
	 * Méthode pour créer une armure.
	 * @return l'item armure créé.
	 */
	public Item newArmure() {
		Item armure = new ItemEquipementArmure((char) 190,Color.black,"armure",2,17);
		world.addItemAtLocation(armure);
		return armure;
	}

	/**
	 * Méthode pour créer une paire de botte.
	 * @return l'item botte créé.
	 */
	public Item newBotte() {
		Item botte = new ItemEquipementBotte((char) 200,Color.black,"botte",1,10);
		world.addItemAtLocation(botte);
		return botte;
	}

	/**
	 * Méthode pour créer un casque.
	 * @return l'item casque créé.
	 */
	public Item newCasque() {
		Item casque = new ItemEquipementCasque((char) 94, Color.black,"casque",1,12);
		world.addItemAtLocation(casque);
		return casque;
	}

	/**
	 * Méthode pour créer un pantalon.
	 * @return l'item pantalon créé.
	 */
	public Item newPantalon() {
		Item pantalon = new ItemEquipementPantalon((char) 186,Color.black,"pantalon",2,14);
		world.addItemAtLocation(pantalon);
		return pantalon;
	}
}
