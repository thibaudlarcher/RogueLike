package player;
import Tiles.*;
import creature.*;
public class PlayerAi extends CreatureAi {

	public PlayerAi(GroupCreature groupCreature) {
		super(groupCreature);
	}

	public void onEnter(int x, int y, Tile tile){
		if (tile.isGround()){
			groupCreature.x = x;
			groupCreature.y = y;
		}
	}
}
