package creature;
import asciiPanel.AsciiPanel;
import world.*;
import player.*;
public class CreatureFactory {
	private World world;
	
	public CreatureFactory(World world){
		this.world = world;
	}
	
	public Creature newPlayer(){
		Creature player = new Creature(world, '@', AsciiPanel.green);
		world.addAtEmptyLocation(player);
		new PlayerAi(player);
		return player;
	}
}
