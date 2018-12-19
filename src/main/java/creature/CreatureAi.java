package creature;

import Tiles.Tile;

/**
 * Classe abstraite des CreaturesAi.
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */
public class CreatureAi {
	/**
	 * Permet de créer un groupe de créature.
	 */
	protected GroupCreature groupCreature;

	/**
	 * Permet de créer un groupe de créature dans une instance de créature ayant l'intelligence artificiel
	 * @param groupCreature un groupe de créature
	 */
	public CreatureAi(GroupCreature groupCreature){
		this.groupCreature = groupCreature;
		this.groupCreature.setCreatureAi(this);
	}

	public void onEnter(int x, int y, Tile tile){
	}
}
