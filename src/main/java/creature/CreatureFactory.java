package creature;
import asciiPanel.AsciiPanel;
import world.*;
import player.*;
import Object.*;
public class CreatureFactory {
	private World world;
	
	public CreatureFactory(World world){
		this.world = world;
	}

	public Creature newPlayer(){
		Creature player = new Creature(world, '@', AsciiPanel.green);
		player.x = world.getPt().x;
		player.y = world.getPt().y;
		new PlayerAi(player);
		return player;
	}

//	public Item newRock(){
//		Item rock = new Item('A', AsciiPanel.yellow, "rock");
//		world.addAtEmptyLocation(rock);
//		return rock;
//	}
}
