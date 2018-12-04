package creature;
import color.Tile;
public class CreatureAi {
	protected GroupCreature groupCreature;
	
	public CreatureAi(GroupCreature groupCreature){
		this.groupCreature = groupCreature;
		this.groupCreature.setCreatureAi(this);
	}
	
	public void onEnter(int x, int y, Tile tile){
	}
}
