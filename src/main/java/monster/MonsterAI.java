package monster;

import Tiles.Tile;
import creature.GroupCreature;
import creature.CreatureAi;

/**
 * Classe des Monstres avec intelligence artificiel
 *
 * @see CreatureAi
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 *
 */

public class MonsterAI extends CreatureAi {
    /**
     * Constructeur de la classe MonstreAI, elle fait appel au constructeur de la classe CreatureAI.
     * @param groupCreature groupe de créature
     */
    public MonsterAI(GroupCreature groupCreature) {
        super(groupCreature);
    }

    /**
     * Permet de checker si on peut placer le Monstre sur la Map.
     * @param x Postition en x
     * @param y Position en y
     * @param tile Le type de la tile
     */
    public void onEnter(int x, int y, Tile tile){
        if (tile.isGround()){
            groupCreature.x = x;
            groupCreature.y = y;
        }
    }
}
