package monster;

import Tiles.Tile;
import creature.GroupCreature;
import creature.CreatureAi;

public class MonsterAI extends CreatureAi {
    public MonsterAI(GroupCreature groupCreature) {
        super(groupCreature);
    }

    public void onEnter(int x, int y, Tile tile){
        if (tile.isGround()){
            groupCreature.x = x;
            groupCreature.y = y;
        }
    }
}
