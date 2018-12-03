package creature;
import asciiPanel.AsciiPanel;
import world.*;
import player.*;
import monster.*;
public class CreatureFactory {
	private World world;
	
	public CreatureFactory(World world){
		this.world = world;
	}
	
	public Creature newPlayer(){
		//244 pied de biche
		Creature player = new Creature(world, '@', AsciiPanel.green);
		player.x = world.getPt().x;
		player.y = world.getPt().y;
		new PlayerAi(player);
		return player;
	}

	/*public Creature newBoss(){
		Creature player = new Creature(world, (char)144, AsciiPanel.green);
		player.x = world.getPt().x;
		player.y = world.getPt().y;
		new PlayerAi(player);
		return player;
	}*/

	public Creature newMonster(){
		Creature monster = new Creature(world, (char)155, AsciiPanel.brightYellow);
		new MonsterAI(monster);
		return monster;
	}
    /*
	public Creature newFlyingMonster(){
		Creature player = new Creature(world, (char)174, AsciiPanel.green);
		player.x = world.getPt().x;
		player.y = world.getPt().y;
		new PlayerAi(player);
		return player;
	}
	*/
}
