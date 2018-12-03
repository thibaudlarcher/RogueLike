package monster;

import color.Tile;
import creature.Creature;
import creature.CreatureAi;

public class MonsterAI extends CreatureAi {
    public MonsterAI(Creature creature) {
        super(creature);
    }

    public void onEnter(int x, int y, Tile tile){
        if (tile.isGround()){
            creature.x = x;
            creature.y = y;
        }
    }
}
