package creature;
import asciiPanel.AsciiPanel;
import creature.Monstre.Kobold;
import creature.PJ.Guerrier;
import creature.PJ.Mage;
import creature.PJ.PJ;
import world.*;
import player.*;
import monster.*;

public class CreatureFactory {
    private World world;

    public CreatureFactory(World world){
        this.world = world;
    }

    public GroupCreature newPlayer(PJ choix){
        //244 pied de biche
        //PJ choice = new Mage("bob",15,10);
        GroupCreature player = new GroupCreature(world, choix.glyph, choix.color, choix);
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
