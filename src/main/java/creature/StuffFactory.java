package creature;
import Object.Items.Item;
import Object.Items.ItemArme;
import asciiPanel.AsciiPanel;
import creature.Monstre.Kobold;
import creature.PJ.Guerrier;
import world.*;
import player.*;
import monster.*;

import java.awt.*;

public class StuffFactory {
	private World world;
	
	public StuffFactory(World world){
		this.world = world;
	}

	public GroupCreature newPlayer(){
		//244 pied de biche
		GroupCreature player = new GroupCreature(world, '@', AsciiPanel.green, new Guerrier("Bob",20,5));
		player.x = world.getPt().x;
		player.y = world.getPt().y;
		new PlayerAi(player);
		return player;
	}

	public Item newSword(){
		Item sword = new ItemArme((char) 180, new Color(128,128,128), "sword",5);
		world.addItemAtLocation(sword);
		return sword;
	}

	public Item newBaton(){
		Item baton = new ItemArme((char) 179,new Color(128,64,0),"baton",2);
		world.addItemAtLocation(baton);
		return baton;
	}

	/*public Creature newBoss(){
		Creature player = new Creature(world, (char)144, AsciiPanel.green);
		player.x = world.getPt().x;
		player.y = world.getPt().y;
		new PlayerAi(player);
		return player;
	}*/

	public GroupCreature newMonster(){
		GroupCreature monster = new GroupCreature(world, (char)155, AsciiPanel.brightYellow, new Kobold(20,5));
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
