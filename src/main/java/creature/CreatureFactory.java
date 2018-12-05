package creature;
import asciiPanel.AsciiPanel;
import creature.Monstre.Kobold;
import creature.PJ.Guerrier;
import world.*;
import player.*;
import monster.*;
public class CreatureFactory {
    private World world;

    public CreatureFactory(World world){
        this.world = world;
    }

    public GroupCreature newPlayer(){
        //244 pied de biche
        GroupCreature player = new GroupCreature(world, '@', AsciiPanel.green,
                new Guerrier("Bob",20,5));
        player.x = world.getPt().x;
        player.y = world.getPt().y;
        new PlayerAi(player);
        return player;
    }

	/*public GroupCreature newBoss(){
		GroupCreature player = new GroupCreature(world, (char)144, AsciiPanel.green);
		player.x = world.getPt().x;
		player.y = world.getPt().y;
		new PlayerAi(player);
		return player;
	}*/

    public GroupCreature newMonster(int x, int y){
		GroupCreature monster = new GroupCreature(world, (char)155, AsciiPanel.brightYellow, x, y);
		new MonsterAI(monster);
		return monster;
    }
    /*
	public GroupCreature newFlyingMonster(){
		GroupCreature player = new GroupCreature(world, (char)174, AsciiPanel.green);
		player.x = world.getPt().x;
		player.y = world.getPt().y;
		new PlayerAi(player);
		return player;
	}
	*/
}
